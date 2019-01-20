package spring.controller;

import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.support.PagedListHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import spring.model.Part;
import spring.service.PartService;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.List;

@Controller
public class PartController {

    private static final Logger logger = Logger.getLogger(PartController.class);

    public PartController() {
        System.out.println("PartController()");
    }

    @Autowired
    private PartService partService;

    @RequestMapping(value = "/")
    public ModelAndView listPart(ModelAndView model, @RequestParam(required = false) Integer page) throws IOException {
        List<Part> listPart2 = partService.getAllParts();
        PagedListHolder<Part> pagedListHolder = new PagedListHolder<>(listPart2);
        pagedListHolder.setPageSize(10);
        model.addObject("maxPages", pagedListHolder.getPageCount());

        if(page == null || page < 1 || page > pagedListHolder.getPageCount()){
            page=1;
        }
        model.addObject("page", page);
        if(page == null || page < 1 || page > pagedListHolder.getPageCount()){
            pagedListHolder.setPage(0);
            model.addObject("listPart", pagedListHolder.getPageList());
        }
        else if(page <= pagedListHolder.getPageCount()) {
            pagedListHolder.setPage(page-1);
            model.addObject("listPart", pagedListHolder.getPageList());
        }
        List<Part> listPart = partService.getNeededParts();
        int count = listPart.get(0).getQuantity();
        for (int i = 0; i < listPart.size(); i++) {
            if (count > listPart.get(i).getQuantity()) {
                count = listPart.get(i).getQuantity();
            }
        }
//        model.addObject("listPart", listPart2);
        model.addObject("count", count);
        model.setViewName("home");
        return model;

    }

    @RequestMapping(value = "/needed")
    public ModelAndView listNeededParts(ModelAndView model, @RequestParam(required = false) Integer page) throws IOException {
        List<Part> listPart = partService.getNeededParts();
        PagedListHolder<Part> pagedListHolder3 = new PagedListHolder<>(listPart);
        pagedListHolder3.setPageSize(10);
        model.addObject("maxPages", pagedListHolder3.getPageCount());

        if(page == null || page < 1 || page > pagedListHolder3.getPageCount()){
            page=1;
        }
        model.addObject("page", page);
        if(page == null || page < 1 || page > pagedListHolder3.getPageCount()){
            pagedListHolder3.setPage(0);
            model.addObject("listPart", pagedListHolder3.getPageList());
        }
        else if(page <= pagedListHolder3.getPageCount()) {
            pagedListHolder3.setPage(page-1);
            model.addObject("listPart", pagedListHolder3.getPageList());
        }
        int count = listPart.get(0).getQuantity();
        for (int i = 0; i < listPart.size(); i++) {
            if (count > listPart.get(i).getQuantity()) {
                count = listPart.get(i).getQuantity();
            }
        }
//        model.addObject("listPart", listPart);
        model.addObject("count", count);
        model.setViewName("needed");
        return model;
    }

    @RequestMapping(value = "/unneeded")
    public ModelAndView listUnneededParts(ModelAndView model, @RequestParam(required = false) Integer page) throws IOException {
        List<Part> listPart3 = partService.getUnneededParts();
        PagedListHolder<Part> pagedListHolder2 = new PagedListHolder<>(listPart3);
        pagedListHolder2.setPageSize(10);
        model.addObject("maxPages", pagedListHolder2.getPageCount());

        if(page == null || page < 1 || page > pagedListHolder2.getPageCount()){
            page=1;
        }
        model.addObject("page", page);
        if(page == null || page < 1 || page > pagedListHolder2.getPageCount()){
            pagedListHolder2.setPage(0);
            model.addObject("listPart", pagedListHolder2.getPageList());
        }
        else if(page <= pagedListHolder2.getPageCount()) {
            pagedListHolder2.setPage(page-1);
            model.addObject("listPart", pagedListHolder2.getPageList());
        }
        List<Part> listPart = partService.getNeededParts();
        int count = listPart.get(0).getQuantity();
        for (int i = 0; i < listPart.size(); i++) {
            if (count > listPart.get(i).getQuantity()) {
                count = listPart.get(i).getQuantity();
            }
        }
//        model.addObject("listPart", listPart2);
        model.addObject("count", count);
        model.setViewName("unneeded");
        return model;
    }

    @RequestMapping(value = "/newPart", method = RequestMethod.GET)
    public ModelAndView newPart(ModelAndView model) {
        Part part = new Part();
        model.addObject("part", part);
        model.setViewName("PartForm");
        return model;
    }

    @RequestMapping(value = "/searchResults", method = RequestMethod.POST)
    public ModelAndView searchPart(@RequestParam("partname")String partname) {
        ModelAndView model = new ModelAndView("searchResults");
        List<Part> listPart = partService.getPartByName(partname);
        model.addObject("listPart", listPart);
        return model;
    }

    @RequestMapping(value = "/savePart", method = RequestMethod.POST)
    public ModelAndView savePart(@ModelAttribute Part part) {
        if (part.getId() == 0) { // if part id is 0 then creating the
            // part other updating the part
            partService.addPart(part);
        } else {
            partService.updatePart(part);
        }
        return new ModelAndView("redirect:/");
    }

//    @RequestMapping(value = "/searchResults", method = RequestMethod.GET)
//    public ModelAndView showSearchResults(@ModelAttribute Part part) {
//        ModelAndView model = new ModelAndView("search");
//        List<Part> listPart = partService.getPartByName(part.getPartName());
//        if (listPart.size() == 0) {
//            String noResult = "Ничего не найдено";
//            model.addObject("noResult", noResult);
//        } else {
//            model.addObject("listPart", listPart);
//        }
//        return model;
//    }

    @RequestMapping(value = "/deletePart", method = RequestMethod.GET)
    public ModelAndView deletePart(HttpServletRequest request) {
        int partId = Integer.parseInt(request.getParameter("id"));
        partService.deletePart(partId);
        return new ModelAndView("redirect:/");
    }

    @RequestMapping(value = "/editPart", method = RequestMethod.GET)
    public ModelAndView editContact(HttpServletRequest request) {
        int partId = Integer.parseInt(request.getParameter("id"));
        Part part = partService.getPart(partId);
        ModelAndView model = new ModelAndView("PartForm");
        model.addObject("part", part);

        return model;
    }
}