package org.javablues.wicket_reusables.behaviors.select2;

import java.io.Serializable;

public class Select2Options implements Serializable {

    private String dropdownParent = "$(document.body)";
    private String width = "resolve";

    private boolean dropdownAutoWidth = false;
    private boolean closeOnSelect = true;
    private boolean debug = false;
    private boolean disabled = false;
    private boolean scrollAfterSelect = false;

    private int maximumInputLength = 0;
    private int maximumSelectionLength = 0;
    private int minimumInputLength = 0;
    private int minimumResultsForSearch = 0;

    public Select2Options() {
    }

    protected String getOptions() {
        StringBuilder options = new StringBuilder();
        options.append("{");

        if (!dropdownParent.equals("$(document.body)")) options.append("dropdownParent:").append(dropdownParent).append(",");
        if (!width.equals("resolve")) options.append("width:'").append(width).append("',");

        if (!closeOnSelect) options.append("closeOnSelect:").append(false).append(",");
        if (dropdownAutoWidth) options.append("dropdownAutoWidth:").append(true).append(",");
        if (debug) options.append("debug:").append(true).append(",");
        if (disabled) options.append("disabled:").append(true).append(",");
        if (scrollAfterSelect) options.append("scrollAfterSelect:").append(true).append(",");

        if (minimumResultsForSearch != 0) options.append("minimumResultsForSearch:").append(minimumResultsForSearch).append(",");
        if (minimumInputLength != 0) options.append("minimumInputLength:").append(minimumInputLength).append(",");
        if (maximumInputLength != 0) options.append("maximumInputLength:").append(maximumInputLength).append(",");
        if (maximumSelectionLength != 0) options.append("maximumSelectionLength:").append(maximumSelectionLength).append(",");

        options.append("}");
        return options.toString();
    }

    public Select2Options withDropdownParent(String dropdownParent) {
        this.dropdownParent = dropdownParent;
        return this;
    }

    public Select2Options withWidth(String width) {
        this.width = width;
        return this;
    }

    public Select2Options withDropdownAutoWidth(boolean dropdownAutoWidth) {
        this.dropdownAutoWidth = dropdownAutoWidth;
        return this;
    }

    public Select2Options withDebug(boolean debug) {
        this.debug = debug;
        return this;
    }

    public Select2Options withDisabled(boolean disabled) {
        this.disabled = disabled;
        return this;
    }

    public Select2Options withScrollAfterSelect(boolean scrollAfterSelect) {
        this.scrollAfterSelect = scrollAfterSelect;
        return this;
    }

    public Select2Options withCloseOnSelect(boolean closeOnSelect) {
        this.closeOnSelect = closeOnSelect;
        return this;
    }

    public Select2Options withMinimumResultsForSearch(int minimumResultsForSearch) {
        this.minimumResultsForSearch = minimumResultsForSearch;
        return this;
    }

    public Select2Options withMinimumInputLength(int minimumInputLength) {
        this.minimumInputLength = minimumInputLength;
        return this;
    }

    public Select2Options withMaximumInputLength(int maximumInputLength) {
        this.maximumInputLength = maximumInputLength;
        return this;
    }

    public Select2Options withMaximumSelectionLength(int maximumSelectionLength) {
        this.maximumSelectionLength = maximumSelectionLength;
        return this;
    }
}
