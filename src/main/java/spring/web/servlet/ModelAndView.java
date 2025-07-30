package spring.web.servlet;

import java.util.HashMap;
import java.util.Map;

public class ModelAndView {
    private String viewName;
    private final Map<String, Object> model = new HashMap<>();

    public String getViewName() {
        return viewName;
    }

    public void setViewName(String viewName) {
        this.viewName = viewName;
    }

    public Map<String, Object> getModel() {
        return model;
    }

    public void addObject(String key, Object value) {
        model.put(key, value);
    }
}
