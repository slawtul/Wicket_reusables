package org.javablues.wicket_reusables.behaviors.shared;

public enum JSEvents {
    ABORT, AFTERPRINT, ANIMATIONEND, ANIMATIONITERATION, ANIMATIONSTART,
    BEFOREPRINT, BEFOREUNLOAD, BLUR, CANPLAY, CANPLAYTHROUGH, CHANGE, CLICK,
    CONTEXTMENU, COPY, CUT, DBLCLICK, DRAG, DRAGEND, DRAGENTER, DRAGLEAVE,
    DRAGOVER, DRAGSTART, DROP, DURATIONCHANGE, ENDED, ERROR, FOCUS, FOCUSIN,
    FOCUSOUT, FULLSCREENCHANGE, FULLSCREENERROR, HASHCHANGE, INPUT, INVALID,
    KEYDOWN, KEYPRESS, KEYUP, LOAD, LOADEDDATA, LOADEDMETADATA, LOADSTART,
    MESSAGE, MOUSEDOWN, MOUSEENTER, MOUSELEAVE, MOUSEMOVE, MOUSEOVER, MOUSEOUT,
    MOUSEUP, OFFLINE, ONLINE, OPEN, PAGEHIDE, PAGESHOW, PASTE, PAUSE, PLAY,
    PLAYING, POPSTATE, PROGRESS, RATECHANGE, RESIZE, RESET, SCROLL, SEARCH,
    SEEKED, SEEKING, SELECT, SHOW, STALLED, STORAGE, SUBMIT, SUSPEND,
    TIMEUPDATE, TOGGLE, TOUCHCANCEL, TOUCHEND, TOUCHMOVE, TOUCHSTART,
    TRANSITIONEND, UNLOAD, VOLUMECHANGE, WAITING, WHEEL;

    @Override
    public String toString() {
        return super.toString().toLowerCase();
    }
}
