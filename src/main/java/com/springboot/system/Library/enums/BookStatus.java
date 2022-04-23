package com.springboot.system.Library.enums;

import java.io.Serializable;

public enum BookStatus implements Serializable {
    AVAILABLE,
    RESERVED,
    LOANED,
    UNKNOWN
}
