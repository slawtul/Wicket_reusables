package org.javablues.wicket_reusables.behaviors.select2;

import java.io.Serializable;

/**
 * <p>
 * Description of all the Select 2 configuration options can be found here:
 * <a href="https://select2.org/configuration/options-api">https://select2.org/configuration/options-api</a>
 * </p>
 */
public class Select2Options implements Serializable {

    private String dropdownParent = "$(document.body)";
    private String width = "resolve";
    private String theme = "default";

    private boolean dropdownAutoWidth = false;
    private boolean closeOnSelect = true;
    private boolean debug = false;
    private boolean disabled = false;
    private boolean scrollAfterSelect = false;
    private boolean selectOnClose = false;

    private int maximumInputLength = 0;
    private int maximumSelectionLength = 0;
    private int minimumInputLength = 0;
    private int minimumResultsForSearch = 0;

    private String data = null;
    private String ajax = null;
    private String containerCss = null;
    private String dropdownCss = null;
    private String language = null;
    private String placeholder = null;
    private String containerCssClass = "''";
    private String dropdownCssClass = "''";

    private String templateResult = null;
    private String templateSelection = null;
    private String sorter = null;
    private String matcher = null;
    private String escapeMarkup = null;

    public Select2Options() {
    }

    protected String getOptions() {
        StringBuilder options = new StringBuilder();
        options.append("{");

        if (!dropdownParent.equalsIgnoreCase("$(document.body)")) options.append("dropdownParent:").append(dropdownParent).append(",");
        if (!width.equalsIgnoreCase("resolve")) options.append("width:'").append(width).append("',");
        if (!theme.equalsIgnoreCase("default")) options.append("theme:'").append(theme).append("',");
        if (!containerCssClass.equals("''")) options.append("containerCssClass:'").append(containerCssClass).append("',");
        if (!dropdownCssClass.equals("''")) options.append("dropdownCssClass:'").append(dropdownCssClass).append("',");

        if (!closeOnSelect) options.append("closeOnSelect:").append(false).append(",");
        if (dropdownAutoWidth) options.append("dropdownAutoWidth:").append(true).append(",");
        if (debug) options.append("debug:").append(true).append(",");
        if (disabled) options.append("disabled:").append(true).append(",");
        if (scrollAfterSelect) options.append("scrollAfterSelect:").append(true).append(",");
        if (!selectOnClose) options.append("selectOnClose:").append(true).append(",");

        if (minimumResultsForSearch != 0) options.append("minimumResultsForSearch:").append(minimumResultsForSearch).append(",");
        if (minimumInputLength != 0) options.append("minimumInputLength:").append(minimumInputLength).append(",");
        if (maximumInputLength != 0) options.append("maximumInputLength:").append(maximumInputLength).append(",");
        if (maximumSelectionLength != 0) options.append("maximumSelectionLength:").append(maximumSelectionLength).append(",");

        if (templateResult != null) options.append("templateResult:").append(templateResult).append(",");
        if (templateSelection != null) options.append("templateSelection:").append(templateSelection).append(",");
        if (sorter != null) options.append("sorter:").append(sorter).append(",");
        if (matcher != null) options.append("matcher:").append(matcher).append(",");
        if (escapeMarkup != null) options.append("escapeMarkup:").append(escapeMarkup).append(",");

        if (data != null) options.append("data:").append(data).append(",");
        if (ajax != null) options.append("ajax:").append(ajax).append(",");
        if (containerCss != null) options.append("containerCss:").append(containerCss).append(",");
        if (dropdownCss != null) options.append("dropdownCss:").append(dropdownCss).append(",");
        if (language != null) options.append("language:").append(language).append(",");
        if (placeholder != null) options.append("placeholder:").append(placeholder).append(",");

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

    public Select2Options withTheme(String theme) {
        this.theme = theme;
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

    public Select2Options withSelectOnClose(boolean selectOnClose) {
        this.selectOnClose = selectOnClose;
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

    public Select2Options withTemplateResult(String templateResult) {
        this.templateResult = templateResult;
        return this;
    }

    public Select2Options withTemplateSelection(String templateSelection) {
        this.templateSelection = templateSelection;
        return this;
    }

    public Select2Options withSorter(String sorter) {
        this.sorter = sorter;
        return this;
    }

    public Select2Options withMatcher(String matcher) {
        this.matcher = matcher;
        return this;
    }

    public Select2Options withEscapeMarkup(String escapeMarkup) {
        this.escapeMarkup = escapeMarkup;
        return this;
    }

    public Select2Options withDropdownCssClass(String dropdownCssClass) {
        this.dropdownCssClass = dropdownCssClass;
        return this;
    }

    public Select2Options withContainerCssClass(String containerCssClass) {
        this.containerCssClass = containerCssClass;
        return this;
    }

    public Select2Options withData(String data) {
        this.data = data;
        return this;
    }

    public Select2Options withAjax(String ajax) {
        this.ajax = ajax;
        return this;
    }

    public Select2Options withContainerCss(String containerCss) {
        this.containerCss = containerCss;
        return this;
    }

    public Select2Options withDropdownCss(String dropdownCss) {
        this.dropdownCss = dropdownCss;
        return this;
    }

    public Select2Options withLanguage(String language) {
        this.language = language;
        return this;
    }

    public Select2Options withPlaceholder(String placeholder) {
        this.placeholder = placeholder;
        return this;
    }
}
