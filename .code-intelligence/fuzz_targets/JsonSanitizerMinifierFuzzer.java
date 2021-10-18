
// Copyright 2021 Code Intelligence GmbH
//
// Licensed under the Apache License, Version 2.0 (the "License");
// you may not use this file except in compliance with the License.
// You may obtain a copy of the License at
//
//      http://www.apache.org/licenses/LICENSE-2.0
//
// Unless required by applicable law or agreed to in writing, software
// distributed under the License is distributed on an "AS IS" BASIS,
// WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
// See the License for the specific lan

package com.example;

import com.code_intelligence.jazzer.api.FuzzedDataProvider;
import com.code_intelligence.jazzer.api.FuzzerSecurityIssueHigh;

import com.google.json.EvalMinifier;

public class JsonSanitizerMinifierFuzzer {
    // 1. The fuzzer calls fuzzerTestOneInput continuously generating new
    // data in each iteration to maximize code coverage and explore more
    // code.
    public static void fuzzerTestOneInput(FuzzedDataProvider data) {
        // 2. Interpret fuzzer-generated data as String since this is the type
        // expected by the method we want to test
        String input = data.consumeRemainingAsString();
        try {
            EvalMinifier.minify(input);
        // we are aware of the exception and want the exception to be ignored    
        } catch (ArrayIndexOutOfBoundsException exceptio) {
            //TODO: handle exception
        }
    }
}
