package mx.payclip.assessment.command;



import com.fasterxml.jackson.databind.ObjectMapper;
import mx.payclip.assessment.dao.TransactionDao;
import mx.payclip.assessment.dao.impl.TransactionFileDao;

import java.io.IOException;

public abstract class Command {
    ObjectMapper mapper = new ObjectMapper();

    public abstract void execute() throws IOException;
    public TransactionDao transactionDao = new TransactionFileDao();

}
