package com.kms.api.util;

import com.kms.api.model.Board;

public class RequestBuilder {

  public static Board requestPayload(String name) {
    Board list = new Board();
    list.setName(name);
    return list;
  }
}
