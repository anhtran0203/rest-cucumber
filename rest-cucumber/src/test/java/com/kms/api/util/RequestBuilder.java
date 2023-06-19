package com.kms.api.util;

import com.kms.api.model.Board;

public class RequestBuilder {

  public static Board requestPayload(String name) {
    Board list = new Board();
    list.setName(name);
    return list;
  }

  public static Board requestPayloadUpdate(String name, String id) {
    Board list = new Board();
    list.setName(name);
    list.setId(id);
    return list;
  }
}
