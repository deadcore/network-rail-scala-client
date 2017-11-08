/*
 * Copyright (c) 2017 igu.io. All Rights Reserved.
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */

package io.igu.networkrail.exception

abstract class NotFoundException(source: String, value: Any) extends RuntimeException(s"$source [$value] has not been found")

class RecordTypeNotFoundException(recordType: String) extends NotFoundException("Record Type", recordType)

class StatusNotFoundException(status: Char) extends NotFoundException("Status", status)

class TransactionTypeNotFoundException(transactionType: Char) extends NotFoundException("Transaction Type", transactionType)

class TransactionCategoryNotFoundException(transactionCategory: String) extends NotFoundException("Transaction Category", transactionCategory)

class CateringNotFoundException(catering: Char) extends NotFoundException("Catering", catering)

class SeatingClassNotFoundException(seatingClass: Char) extends NotFoundException("Seating class", seatingClass)
