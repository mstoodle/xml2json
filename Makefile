###############################################################################
# Copyright (c) 2018, 2018 IBM Corp. and others
#
# This program and the accompanying materials are made available under
# the terms of the Apache License, Version 2.0 which accompanies this
# distribution and is available at https://www.apache.org/licenses/LICENSE-2.0.
#
# SPDX-License-Identifier: Apache-2.0
###############################################################################

gclog.json: gclog.sample xml2json.class
	java -cp .:json-20180813.jar xml2json gclog.sample > gclog.json
	cat gclog.json

xml2json.class: src/xml2json.java
	javac -d . -cp ./json-20180813.jar src/xml2json.java
