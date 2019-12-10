package org.fisco.bcos.v2.rpc;

import java.io.IOException;
import java.math.BigInteger;
import java.util.Arrays;

import org.fisco.bcos.v2.rpc.methods.request.Request;
import org.fisco.bcos.v2.web3j.Web3j;
import org.fisco.bcos.v2.common.Numeric;
import org.fisco.bcos.v2.rpc.service.RpcService;
import org.fisco.bcos.v2.rpc.service.ChannelService;
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
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @description JSON-RPC 2.0 factory implementation.
 */
public class JsonRpc2_0 implements Web3j {
    static Logger logger = LoggerFactory.getLogger(JsonRpc2_0.class);

    protected RpcService rpcService;

    private int groupId = 1;

    public JsonRpc2_0(RpcService rpcService, int groupId) {
        this.groupId = groupId;
        this.rpcService = rpcService;
    }

    public int getGroupId() {
        return groupId;
    }

    public void setGroupId(int groupId) {
        this.groupId = groupId;
    }

    public RpcService getRpcService() {
        return rpcService;
    }

    @Override
    public Request<?, NodeVersion> getNodeVersion() {
        return new Request<>("getClientVersion", Arrays.asList(), rpcService, NodeVersion.class);
    }

    @Override
    public synchronized Request<?, BlockNumber> getBlockNumber() {
        return new Request<>(
                "getBlockNumber", Arrays.asList(groupId), rpcService, BlockNumber.class);
    }

    @Override
    public Request<?, GroupList> getGroupList() {
        return new Request<>("getGroupList", Arrays.asList(), rpcService, GroupList.class);
    }

    @Override
    public Request<?, SealerList> getSealerList() {
        return new Request<>(
                "getSealerList", Arrays.asList(groupId), rpcService, SealerList.class);
    }

    @Override
    public Request<?, ObserverList> getObserverList() {
        return new Request<>(
                "getObserverList", Arrays.asList(groupId), rpcService, ObserverList.class);
    }

    @Override
    public Request<?, Peers> getPeers() {
        return new Request<>("getPeers", Arrays.asList(groupId), rpcService, Peers.class);
    }

    @Override
    public Request<?, NodeIDList> getNodeIDList() {
        return new Request<>(
                "getNodeIDList", Arrays.asList(groupId), rpcService, NodeIDList.class);
    }

    @Override
    public Request<?, SystemConfig> getSystemConfigByKey(String key) {
        return new Request<>(
                "getSystemConfigByKey",
                Arrays.asList(groupId, key),
                rpcService,
                SystemConfig.class);
    }

    @Override
    public Request<?, SyncStatus> getSyncStatus() {
        return new Request<>(
                "getSyncStatus", Arrays.asList(groupId), rpcService, SyncStatus.class);
    }

    @Override
    public Request<?, PbftView> getPbftView() {
        return new Request<>("getPbftView", Arrays.asList(groupId), rpcService, PbftView.class);
    }

    @Override
    public Request<?, ConsensusStatus> getConsensusStatus() {
        return new Request<>(
                "getConsensusStatus",
                Arrays.asList(groupId),
                (ChannelService) rpcService,
                ConsensusStatus.class);
    }

    @Override
    public Request<?, Code> getCode(String address) {
        return new Request<>("getCode", Arrays.asList(groupId, address), rpcService, Code.class);
    }

    @Override
    public Request<?, TotalTransactionCount> getTotalTransactionCount() {
        return new Request<>(
                "getTotalTransactionCount",
                Arrays.asList(groupId),
                rpcService,
                TotalTransactionCount.class);
    }

    @Override
    public Request<?, Call> call(
            org.fisco.bcos.v2.rpc.methods.request.Transaction transaction) {
        return new Request<>("call", Arrays.asList(groupId, transaction), rpcService, Call.class);
    }

    @Override
    public Request<?, BcosBlock> getBlockByHash(
            String blockHash, boolean returnFullTransactionObjects) {
        return new Request<>(
                "getBlockByHash",
                Arrays.asList(groupId, blockHash, returnFullTransactionObjects),
                rpcService,
                BcosBlock.class);
    }

    @Override
    public Request<?, BcosBlock> getBlockByNumber(
            BigInteger blockNumber, boolean returnFullTransactionObjects) {
        return new Request<>(
                "getBlockByNumber",
                Arrays.asList(
                        groupId, blockNumber, returnFullTransactionObjects),
                rpcService,
                BcosBlock.class);
    }

    @Override
    public Request<?, BlockHash> getBlockHashByNumber(BigInteger blockNumber) {
        return new Request<>(
                "getBlockHashByNumber",
                Arrays.asList(groupId, blockNumber),
                rpcService,
                BlockHash.class);
    }

    @Override
    public Request<?, BcosTransaction> getTransactionByHash(String transactionHash) {
        return new Request<>(
                "getTransactionByHash",
                Arrays.asList(groupId, transactionHash),
                rpcService,
                BcosTransaction.class);
    }

    @Override
    public Request<?, TransactionWithProof> getTransactionByHashWithProof(String transactionHash) {
        return new Request<>(
                "getTransactionByHashWithProof",
                Arrays.asList(groupId, transactionHash),
                rpcService,
                TransactionWithProof.class);
    }

    @Override
    public Request<?, BcosTransaction> getTransactionByBlockHashAndIndex(
            String blockHash, BigInteger transactionIndex) {
        return new Request<>(
                "getTransactionByBlockHashAndIndex",
                Arrays.asList(groupId, blockHash, Numeric.encodeQuantity(transactionIndex)),
                rpcService,
                BcosTransaction.class);
    }

    @Override
    public Request<?, BcosTransaction> getTransactionByBlockNumberAndIndex(
            BigInteger blockNumber, BigInteger transactionIndex) {
        return new Request<>(
                "getTransactionByBlockNumberAndIndex",
                Arrays.asList(
                        groupId,
                        blockNumber,
                        Numeric.encodeQuantity(transactionIndex)),
                rpcService,
                BcosTransaction.class);
    }

    @Override
    public Request<?, BcosTransactionReceipt> getTransactionReceipt(String transactionHash) {
        return new Request<>(
                "getTransactionReceipt",
                Arrays.asList(groupId, transactionHash),
                rpcService,
                BcosTransactionReceipt.class);
    }

    @Override
    public Request<?, TransactionReceiptWithProof> getTransactionReceiptByHashWithProof(
            String transactionHash) {
        return new Request<>(
                "getTransactionReceiptByHashWithProof",
                Arrays.asList(groupId, transactionHash),
                rpcService,
                TransactionReceiptWithProof.class);
    }

    @Override
    public Request<?, PendingTransactions> getPendingTransaction() {
        return new Request<>(
                "getPendingTransactions",
                Arrays.asList(groupId),
                rpcService,
                PendingTransactions.class);
    }

    @Override
    public Request<?, PendingTxSize> getPendingTxSize() {
        return new Request<>(
                "getPendingTxSize", Arrays.asList(groupId), rpcService, PendingTxSize.class);
    }

    @Override
    public Request<?, SendTransaction> sendRawTransaction(String signedTransactionData) {
        return new Request<>(
                "sendRawTransaction",
                Arrays.asList(groupId, signedTransactionData),
                rpcService,
                SendTransaction.class);
    }

    @Override
    public Request<?, GroupPeers> getGroupPeers() {
        return new Request<>(
                "getGroupPeers", Arrays.asList(groupId), rpcService, GroupPeers.class);
    }

    public void shutdown() {
        try {
            rpcService.close();
        } catch (IOException e) {
            throw new RuntimeException("Failed to close web3j service", e);
        }
    }
}
