package mx.payclip.assessment.dao.impl;


import com.fasterxml.jackson.databind.ObjectMapper;
import mx.payclip.assessment.dao.TransactionDao;
import mx.payclip.assessment.dto.SumResultDto;
import mx.payclip.assessment.dto.TransactionDto;

import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class TransactionFileDao implements TransactionDao {

    private String currentDirectory = System.getProperty("user.dir").concat(File.separator).concat("db").concat(File.separator);
    ObjectMapper mapper = new ObjectMapper();

    @Override
    public Optional<TransactionDto> saveTransaction(Integer userId, TransactionDto transaction) {
        String newDir = currentDirectory + userId;
        new File(newDir).mkdirs();
        String newTransactionID = java.util.UUID.randomUUID().toString();
        transaction.setTransactionId(newTransactionID);
        try {
            mapper.writeValue(new File(newDir + File.separator + newTransactionID), transaction);
        } catch (IOException e) {
            return Optional.empty();
        }
        return Optional.of(transaction);
    }

    @Override
    public Optional<TransactionDto> findByUserIdAndTransactionId(Integer userId, String transactionId) {
        String file = currentDirectory + userId + File.separator + transactionId;
        TransactionDto transactionDto;
        try {
            transactionDto = mapper.readValue(new File(file), TransactionDto.class);
        } catch (IOException e) {
            return Optional.empty();
        }
        if (userId.equals(transactionDto.getUserId())) {
            return Optional.of(transactionDto);
        } else {
            return Optional.empty();
        }
    }

    @Override
    public List<TransactionDto> findAllByUserId(Integer userId) {
        File folder = new File(currentDirectory + userId);
        String[] listOfFiles = folder.list();

        List<TransactionDto> list = new ArrayList<>();
        if (listOfFiles != null) {
            for (String transactionId : listOfFiles) {
                Optional<TransactionDto> dtoOptional = this.findByUserIdAndTransactionId(userId, transactionId);
                dtoOptional.ifPresent(list::add);
            }
            list.sort(Comparator.comparing(TransactionDto::getDate));
        }

        return list;
    }

    @Override
    public SumResultDto sumAllByUserId(Integer userId) {
        List<TransactionDto> transactionDtoList = findAllByUserId(userId);

        SumResultDto sumResultDto = new SumResultDto();
        sumResultDto.setUserId(userId);
        if (transactionDtoList.size() > 0) {
            sumResultDto.setSum(transactionDtoList.stream().map(TransactionDto::getAmount).reduce(BigDecimal.ZERO, BigDecimal::add));
        }else{
            sumResultDto.setSum(BigDecimal.ZERO);
        }
        return sumResultDto;
    }
}
