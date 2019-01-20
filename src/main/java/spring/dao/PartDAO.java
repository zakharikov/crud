package spring.dao;

import spring.model.Part;
import java.util.List;

public interface PartDAO {

    public void addPart(Part part);
    public List<Part> getAllParts();
    public List<Part> getNeededParts();
    public List<Part> getUnneededParts();
    public void deletePart(Integer id);
    public Part updatePart(Part part);
    public Part getPart(Integer id);
    public List<Part> getPartByName(String name);

}
