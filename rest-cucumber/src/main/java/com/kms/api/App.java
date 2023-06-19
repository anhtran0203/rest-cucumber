package com.kms.api;

import com.kms.api.utils.Utils;
import java.io.File;
import java.io.IOException;

/** Hello world! */
public class App {
  public static void main(String[] args) throws IOException {
    Utils.convertJsonToJavaClass(
        new File("rest-cucumber/rest-cucumber/src/main/resources/data/list.json").toURI().toURL(),
        new File("rest-cucumber/rest-cucumber/src/main/java/com/kms/api"),
        "model",
        "board");
  }
}
