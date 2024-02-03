package edu.icet.crm.dao.custom.impl;

import edu.icet.crm.dao.custom.PartDao;
import edu.icet.crm.dao.util.HibernateUtil;
import edu.icet.crm.dto.PartDto;
import edu.icet.crm.entity.ItemsEntity;
import edu.icet.crm.entity.PartEntity;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class PartDaoImpl implements PartDao {
    @Override
    public boolean savePart(PartDto partDto) {
        try (Session session = HibernateUtil.getSession()) {
            Transaction transaction = session.beginTransaction();

            try {
                // Retrieve the ItemsEntity for the given itemId
                ItemsEntity itemEntity = session.get(ItemsEntity.class, partDto.getItemId());

                // Create a new PartEntity based on the PartDto
                PartEntity partEntity = new PartEntity(
                        partDto.getName(),
                        partDto.getQuantity(),
                        partDto.getPrice()
                );

                // Set the reference to the ItemsEntity
                partEntity.setItem(itemEntity);

                // Save the PartEntity
                session.save(partEntity);

                transaction.commit();
                return true;
            } catch (Exception e) {
                e.printStackTrace();
                transaction.rollback();
                return false;
            }
        }
    }
}
