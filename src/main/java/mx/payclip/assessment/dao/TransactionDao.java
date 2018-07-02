package mx.payclip.assessment.dao;


import mx.payclip.assessment.dto.SumResultDto;
import mx.payclip.assessment.dto.TransactionDto;

import java.util.List;
import java.util.Optional;

public interface TransactionDao {


    Optional <TransactionDto> saveTransaction(Integer userId, TransactionDto transaction);

    Optional<TransactionDto> findByUserIdAndTransactionId(Integer userId, String transactionId);

    List<TransactionDto> findAllByUserId(Integer userId);

    SumResultDto sumAllByUserId(Integer userId);
}
