package edu.icet.crm.bo.custom.impl;

import edu.icet.crm.bo.custom.ItemsViewBo;
import edu.icet.crm.dao.DaoFactory;
import edu.icet.crm.dao.custom.ItemsViewDao;
import edu.icet.crm.dao.custom.OrdersViewDao;
import edu.icet.crm.dao.custom.PartDao;
import edu.icet.crm.dao.util.DaoType;
import edu.icet.crm.dto.ItemDto;
import edu.icet.crm.dto.PartDto;
import edu.icet.crm.entity.ItemsEntity;
import edu.icet.crm.entity.OrdersEntity;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class ItemsViewBoImpl implements ItemsViewBo {
    ItemsViewDao itemsViewDao= DaoFactory.getInstance().getDao(DaoType.ITEMS_VIEW_DAO);
    OrdersViewDao ordersViewDao=DaoFactory.getInstance().getDao(DaoType.ORDERS_VIEW_DAO);
    PartDao partDao=DaoFactory.getInstance().getDao(DaoType.PART_DAO);


    @Override
    public List<ItemDto> getAllItems(){
        List<ItemDto> itemDtoList=new ArrayList<>();
        for (ItemsEntity itemsEntity:itemsViewDao.getAllItems()){
            itemDtoList.add(new ItemDto(
                    itemsEntity.getItemId(),
                    itemsEntity.getStatus(),
                    itemsEntity.getCategory(),
                    itemsEntity.getName(),
                    itemsEntity.getOrder().getOrderId()
            ));
        }
        return itemDtoList;
    }

    @Override
    public boolean deleteItem(String itemId) {
        return itemsViewDao.deleteItem(itemId);
    }

    @Override
    public boolean updateItemStatus(String orderId, String newStatus) {
        System.out.println("updateItemStatus");
        boolean updateItemStatus = itemsViewDao.updateItemStatus(orderId, newStatus);
        checkAndUpdateOrderStatus(orderId);
        return updateItemStatus;
    }

    private void checkAndUpdateOrderStatus(String itemId) {
        System.out.println("checkAndUpdateOrderStatus");
        String orderId = itemsViewDao.getOrderIdByItemId(itemId);
        int itemCount = itemsViewDao.getOrderItemCountByStatus(orderId, "COMPLETED");
        int totalItemCount = itemsViewDao.getTotalItemCountByOrderId(orderId);
        System.out.println(itemCount);
        System.out.println(totalItemCount);

        if (itemCount == totalItemCount) {
            ordersViewDao.updateOrder(new OrdersEntity(orderId, "COMPLETED", null));
            sendEmailToCustomer(orderId);
        }
    }

    private void sendEmailToCustomer(String orderId) {
        System.out.println("sendEmailToCustomer");

        String customerEmail = itemsViewDao.getCustomerEmailByOrderId(orderId);

        String subject = "Order Completed";
        String body = "Dear Customer,\nYour order with ID " + orderId + " has been completed successfully.";

        sendEmail(customerEmail, subject, body);
    }

    private void sendEmail(String toEmail, String subject, String body) {
        System.out.println("sendEmail");
        final String username = "minura21173@gmail.com";
        final String password = "debt dqbn vjyk anxu";

        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");

        Session session = Session.getInstance(props,
                new Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(username, password);
                    }
                });

        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(username));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(toEmail));
            message.setSubject(subject);
            message.setText(body);

            Transport.send(message);

            System.out.println("Email sent successfully.");

        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }

    @Override
    public boolean isItemPendingForMoreThan10Days(String itemId) {
        String orderDateStr = itemsViewDao.getOrderDateByItemId(itemId);

        if (orderDateStr != null) {
            //format "yyyy-MM-dd"
            LocalDate orderDate = LocalDate.parse(orderDateStr);
            System.out.println(orderDate);
            LocalDate currentDate = LocalDate.now();

            long daysBetween = ChronoUnit.DAYS.between(orderDate, currentDate);

            return daysBetween > 10;
        }

        return false;
    }

    @Override
    public boolean savePart(PartDto partDto){
        return partDao.savePart(partDto);
    }
}
