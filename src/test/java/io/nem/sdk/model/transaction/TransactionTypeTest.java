/*
 * Copyright 2018 NEM
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package io.nem.sdk.model.transaction;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TransactionTypeTest {
    @Test
    void aggregateCompleteType() {
        TransactionType transactionType = TransactionType.AGGREGATE_COMPLETE;
        assertEquals(0x4141, transactionType.getValue());
        assertEquals(16705, transactionType.getValue());
        assertEquals(TransactionType.AGGREGATE_COMPLETE, TransactionType.rawValueOf(16705));
    }

    @Test
    void aggregateBondedType() {
        TransactionType transactionType = TransactionType.AGGREGATE_BONDED;
        assertEquals(0x4241, transactionType.getValue());
        assertEquals(16961, transactionType.getValue());
        assertEquals(TransactionType.AGGREGATE_BONDED, TransactionType.rawValueOf(16961));
    }

    @Test
    void mosaicCreationType() {
        TransactionType transactionType = TransactionType.MOSAIC_DEFINITION;
        assertEquals(0x414d, transactionType.getValue());
        assertEquals(16717, transactionType.getValue());
        assertEquals(TransactionType.MOSAIC_DEFINITION, TransactionType.rawValueOf(16717));
    }

    @Test
    void mosaicSupplyChangeType() {
        TransactionType transactionType = TransactionType.MOSAIC_SUPPLY_CHANGE;
        assertEquals(0x424d, transactionType.getValue());
        assertEquals(16973, transactionType.getValue());
        assertEquals(TransactionType.MOSAIC_SUPPLY_CHANGE, TransactionType.rawValueOf(16973));
    }

    @Test
    void multisigModificationType() {
        TransactionType transactionType = TransactionType.MODIFY_MULTISIG_ACCOUNT;
        assertEquals(0x4155, transactionType.getValue());
        assertEquals(16725, transactionType.getValue());
        assertEquals(TransactionType.MODIFY_MULTISIG_ACCOUNT, TransactionType.rawValueOf(16725));
    }

    @Test
    void namespaceCreationType() {
        TransactionType transactionType = TransactionType.REGISTER_NAMESPACE;
        assertEquals(0x414e, transactionType.getValue());
        assertEquals(16718, transactionType.getValue());
        assertEquals(TransactionType.REGISTER_NAMESPACE, TransactionType.rawValueOf(16718));
    }

    @Test
    void transferType() {
        TransactionType transactionType = TransactionType.TRANSFER;
        assertEquals(0x4154, transactionType.getValue());
        assertEquals(16724, transactionType.getValue());
        assertEquals(TransactionType.TRANSFER, TransactionType.rawValueOf(16724));
    }

    @Test
    void lockFundsType() {
        TransactionType transactionType = TransactionType.LOCK;
        assertEquals(0x414C, transactionType.getValue());
        assertEquals(16716, transactionType.getValue());
        assertEquals(TransactionType.LOCK, TransactionType.rawValueOf(16716));
    }

    @Test
    void secretLockType() {
        TransactionType transactionType = TransactionType.SECRET_LOCK;
        assertEquals(0x424C, transactionType.getValue());
        assertEquals(16972, transactionType.getValue());
        assertEquals(TransactionType.SECRET_LOCK, TransactionType.rawValueOf(16972));
    }

    @Test
    void secretProofType() {
        TransactionType transactionType = TransactionType.SECRET_PROOF;
        assertEquals(0x434C, transactionType.getValue());
        assertEquals(17228, transactionType.getValue());
        assertEquals(TransactionType.SECRET_PROOF, TransactionType.rawValueOf(17228));
    }
}