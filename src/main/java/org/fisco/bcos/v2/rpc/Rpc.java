package org.fisco.bcos.v2.rpc;

import java.math.BigInteger;

import org.fisco.bcos.v2.rpc.methods.request.Request;
import org.fisco.bcos.v2.rpc.methods.response.BcosBlock;
import org.fisco.bcos.v2.rpc.methods.response.BcosTransaction;
import org.fisco.bcos.v2.rpc.methods.response.BcosTransactionReceipt;
import org.fisco.bcos.v2.rpc.methods.response.BlockHash;
import org.fisco.bcos.v2.rpc.methods.response.BlockNumber;
import org.fisco.bcos.v2.rpc.methods.response.Call;
import org.fisco.bcos.v2.rpc.methods.response.Code;
import org.fisco.bcos.v2.rpc.methods.response.ConsensusStatus;
import org.fisco.bcos.v2.rpc.methods.response.GroupList;
import org.fisco.bcos.v2.rpc.methods.response.GroupPeers;
import org.fisco.bcos.v2.rpc.methods.response.NodeIDList;
import org.fisco.bcos.v2.rpc.methods.response.NodeVersion;
import org.fisco.bcos.v2.rpc.methods.response.ObserverList;
import org.fisco.bcos.v2.rpc.methods.response.PbftView;
import org.fisco.bcos.v2.rpc.methods.response.Peers;
import org.fisco.bcos.v2.rpc.methods.response.PendingTransactions;
import org.fisco.bcos.v2.rpc.methods.response.PendingTxSize;
import org.fisco.bcos.v2.rpc.methods.response.SealerList;
import org.fisco.bcos.v2.rpc.methods.response.SendTransaction;
import org.fisco.bcos.v2.rpc.methods.response.SyncStatus;
import org.fisco.bcos.v2.rpc.methods.response.SystemConfig;
import org.fisco.bcos.v2.rpc.methods.response.TotalTransactionCount;
import org.fisco.bcos.v2.rpc.methods.response.TransactionReceiptWithProof;
import org.fisco.bcos.v2.rpc.methods.response.TransactionWithProof;

/**
 * @description  FISCO-BCOS JSON-RPC API.
 */
public interface Rpc {

    Request<?, NodeVersion> getNodeVersion();

    Request<?, BlockNumber> getBlockNumber();

    Request<?, PbftView> getPbftView();

    Request<?, SealerList> getSealerList();

    Request<?, ObserverList> getObserverList();

    Request<?, NodeIDList> getNodeIDList();

    Request<?, GroupList> getGroupList();

    Request<?, GroupPeers> getGroupPeers();

    Request<?, Peers> getPeers();

    Request<?, ConsensusStatus> getConsensusStatus();

    Request<?, SyncStatus> getSyncStatus();

    Request<?, SystemConfig> getSystemConfigByKey(String key);

    Request<?, Code> getCode(String address);

    Request<?, TotalTransactionCount> getTotalTransactionCount();

    Request<?, BcosBlock> getBlockByHash(String blockHash, boolean returnFullTransactionObjects);

    Request<?, BcosBlock> getBlockByNumber(
            BigInteger blockNumber, boolean returnFullTransactionObjects);

    Request<?, BlockHash> getBlockHashByNumber(BigInteger blockNumber);

    Request<?, BcosTransaction> getTransactionByHash(String transactionHash);

    Request<?, TransactionWithProof> getTransactionByHashWithProof(String transactionHash);

    Request<?, BcosTransaction> getTransactionByBlockHashAndIndex(
            String blockHash, BigInteger transactionIndex);

    Request<?, BcosTransaction> getTransactionByBlockNumberAndIndex(
            BigInteger blockNumber, BigInteger transactionIndex);

    Request<?, BcosTransactionReceipt> getTransactionReceipt(String transactionHash);

    Request<?, TransactionReceiptWithProof> getTransactionReceiptByHashWithProof(
            String transactionHash);

    Request<?, PendingTransactions> getPendingTransaction();

    Request<?, PendingTxSize> getPendingTxSize();

    Request<?, Call> call(
            org.fisco.bcos.v2.rpc.methods.request.Transaction transaction);

    Request<?, SendTransaction> sendRawTransaction(String signedTransactionData);
}
