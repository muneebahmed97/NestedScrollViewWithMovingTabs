package com.example.nestedscrollwithtabs.model;

public class TabItem {

    public TabItem(boolean isSelected, String title) {
        this.isSelected = isSelected;
        this.title = title;
    }

    private boolean isSelected;
    private String title;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public boolean isSelected() {
        return isSelected;
    }

    public void setSelected(boolean selected) {
        isSelected = selected;
    }
}
