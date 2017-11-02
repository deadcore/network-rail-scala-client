package io.igu.networkrail.exception

abstract class NotFoundException(source: String, value: Any) extends RuntimeException(s"$source [$value] has not been found")

class RecordTypeNotFoundException(recordType: String) extends NotFoundException("Record Type", recordType)

class StatusNotFoundException(status: Char) extends NotFoundException("Status", status)

class TransactionTypeNotFoundException(transactionType: Char) extends NotFoundException("Transaction Type", transactionType)

class TransactionCategoryNotFoundException(transactionCategory: String) extends NotFoundException("Transaction Category", transactionCategory)

class CateringNotFoundException(catering: Char) extends NotFoundException("Catering", catering)

class SeatingClassNotFoundException(seatingClass: Char) extends NotFoundException("Seating class", seatingClass)
