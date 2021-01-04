package com.dnd.project.common.token;

import lombok.Builder;
import lombok.Getter;


public interface AuthenticationToken {
    String getToken();
}

