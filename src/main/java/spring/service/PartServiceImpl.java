package spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import spring.dao.PartDAO;
import spring.model.Part;

import java.util.List;

@Service
public class PartServiceImpl implements PartService {

    @Autowired
    private PartDAO partDAO;

    public void setPartDAO(PartDAO partDAO) {
        this.partDAO = partDAO;
    }

    @Override
    @Transactional
    public void addPart(Part p) {
        this.partDAO.addPart(p);
    }

    @Override
    @Transactional
    public Part updatePart(Part p) {
        this.partDAO.updatePart(p);
        return p;
    }

    @Override
    @Transactional
    public List<Part> getAllParts() {
        return this.partDAO.getAllParts();
    }

    @Override
    @Transactional
    public List<Part> getNeededParts() {
        return this.partDAO.getNeededParts();
    }

    @Override
    @Transactional
    public List<Part> getUnneededParts() {
        return this.partDAO.getUnneededParts();
    }

    @Override
    @Transactional
    public Part getPart(Integer id) {
        return this.partDAO.getPart(id);
    }

    @Override
    @Transactional
    public List<Part> getPartByName(String name) {
        return this.partDAO.getPartByName(name);
    }

    @Override
    @Transactional
    public void deletePart(Integer id) {
        this.partDAO.deletePart(id);
    }

}

