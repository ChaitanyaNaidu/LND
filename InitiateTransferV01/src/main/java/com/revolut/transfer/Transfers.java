package com.revolut.transfer;

import com.revolut.*;
import com.revolut.rest.web.*;

public interface Transfers {
    Integer initiateTransfers(InitiateTransferRequest initiateTransferRequest) throws TransferException;
}
