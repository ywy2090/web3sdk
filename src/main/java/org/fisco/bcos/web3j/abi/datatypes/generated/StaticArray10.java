package org.fisco.bcos.web3j.abi.datatypes.generated;

import java.util.List;
import org.fisco.bcos.web3j.abi.datatypes.StaticArray;
import org.fisco.bcos.web3j.abi.datatypes.Type;

/**
 * Auto generated code.
 *
 * <p><strong>Do not modifiy!</strong>
 *
 * <p>Please use AbiTypesGenerator in the <a
 * href="https://github.com/web3j/web3j/tree/master/codegen">codegen module</a> to update.
 */
public class StaticArray10<T extends Type> extends StaticArray<T> {
    public StaticArray10(List<T> values) {
        super(10, values);
    }

    @SafeVarargs
    public StaticArray10(T... values) {
        super(10, values);
    }
}
