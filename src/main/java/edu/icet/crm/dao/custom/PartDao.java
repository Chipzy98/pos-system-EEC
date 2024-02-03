package edu.icet.crm.dao.custom;

import edu.icet.crm.dao.SuperDao;
import edu.icet.crm.dto.PartDto;

public interface PartDao extends SuperDao {
    boolean savePart(PartDto partDto);
}
