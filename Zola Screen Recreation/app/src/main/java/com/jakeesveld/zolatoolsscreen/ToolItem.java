package com.jakeesveld.zolatoolsscreen;

import java.util.List;

public class ToolItem {
    private String name, desc;
    private int iconId;
    private List<String> links;
    private boolean expanded;

    public ToolItem(String name, String desc, int iconId, List<String> links) {
        this.name = name;
        this.desc = desc;
        this.iconId = iconId;
        this.links = links;
        this.expanded = false;
    }

    public boolean isExpanded() {
        return expanded;
    }

    public void setExpanded(boolean expanded) {
        this.expanded = expanded;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public int getIconId() {
        return iconId;
    }

    public void setIconId(int iconId) {
        this.iconId = iconId;
    }

    public List<String> getLinks() {
        return links;
    }

    public void setLinks(List<String> links) {
        this.links = links;
    }
}
