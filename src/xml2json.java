/******************************************************************************
 * Copyright (c) 2018, 2018 IBM Corp. and others
 *
 * This program and the accompanying materials are made available under
 * the terms of the Apache License, Version 2.0 which accompanies this
 * distribution and is available at https://www.apache.org/licenses/LICENSE-2.0.
 *
 * SPDX-License-Identifier: Apache-2.0
 ******************************************************************************/

import org.json.JSONObject;
import org.json.JSONException;
import org.json.XML;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.io.IOException;

public class xml2json {
    public static void main(String[] args) {
        if (args.length != 1) {
            System.err.println("Usage: xml2json <xml input file>");
            System.exit(-1);
        }
        String xmlFileName = args[0];
        String xmlString=null;
        try {
            xmlString = new String(Files.readAllBytes(Paths.get(xmlFileName)), "UTF-8");
        } catch (IOException e) {
            System.err.println("Could not read input xml file: " + xmlFileName);
            System.exit(-1);
        }

        try {
            JSONObject xmlJSONObj = XML.toJSONObject(xmlString);
            String jsonPrettyPrintString = xmlJSONObj.toString(4);
            System.out.println(jsonPrettyPrintString);
        } catch (JSONException je) {
            System.err.println(je.toString());
        }
    }
}
