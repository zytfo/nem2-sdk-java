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

package io.nem.core.utils;

import org.hamcrest.core.IsEqual;
import org.junit.Assert;
import org.junit.Test;

public class HexEncoderTest {

    //region getBytes

    private static void assertGetBytesConversion(final String input, final byte[] expectedOutput) {
        // Act:
        final byte[] output = HexEncoder.getBytes(input);

        // Assert:
        Assert.assertThat(output, IsEqual.equalTo(expectedOutput));
    }

    private static void assertTryGetBytesConversion(final String input, final byte[] expectedOutput) {
        // Act:
        final byte[] output = HexEncoder.tryGetBytes(input);

        // Assert:
        Assert.assertThat(output, IsEqual.equalTo(expectedOutput));
    }

    private static void assertGetStringConversion(final byte[] input, final String expectedOutput) {
        // Act:
        final String output = HexEncoder.getString(input);

        // Assert:
        Assert.assertThat(output, IsEqual.equalTo(expectedOutput));
    }

	/*@Test
	public void getBytesCannotConvertMalformedStringToByteArray() {
		// Act:
		ExceptionAssert.assertThrows(v -> HexEncoder.getBytes("4e454g465457"), IllegalArgumentException.class);
	}*/

    @Test
    public void getBytesCanConvertValidStringToByteArray() {
        // Assert:
        assertGetBytesConversion(
                "4e454d465457",
                new byte[]{0x4e, 0x45, 0x4d, 0x46, 0x54, 0x57});
    }

    //endregion

    //region tryGetBytes

    @Test
    public void getBytesCanConvertValidStringWithOddLengthToByteArray() {
        // Assert:
        assertGetBytesConversion(
                "e454d465457",
                new byte[]{0x0e, 0x45, 0x4d, 0x46, 0x54, 0x57});
    }

    @Test
    public void getBytesCanConvertValidStringWithLeadingZerosToByteArray() {
        // Assert:
        assertGetBytesConversion(
                "00000d465457",
                new byte[]{0x00, 0x00, 0x0d, 0x46, 0x54, 0x57});
    }

    @Test
    public void tryGetBytesCanConvertValidStringToByteArray() {
        // Assert:
        assertTryGetBytesConversion(
                "4e454d465457",
                new byte[]{0x4e, 0x45, 0x4d, 0x46, 0x54, 0x57});
    }

    @Test
    public void tryGetBytesCanConvertValidStringWithOddLengthToByteArray() {
        // Assert:
        assertTryGetBytesConversion(
                "e454d465457",
                new byte[]{0x0e, 0x45, 0x4d, 0x46, 0x54, 0x57});
    }

    @Test
    public void tryGetBytesCanConvertValidStringWithLeadingZerosToByteArray() {
        // Assert:
        assertTryGetBytesConversion(
                "00000d465457",
                new byte[]{0x00, 0x00, 0x0d, 0x46, 0x54, 0x57});
    }

    //endregion

    //region getString

    @Test
    public void tryGetBytesCannotConvertMalformedStringToByteArray() {
        // Assert:
        assertTryGetBytesConversion(
                "4e454g465457",
                null);
    }

    @Test
    public void getStringCanConvertBytesToHexString() {
        // Assert:
        assertGetStringConversion(
                new byte[]{0x4e, 0x45, 0x4d, 0x46, 0x54, 0x57},
                "4e454d465457");
    }

    @Test
    public void getStringCanConvertBytesWithLeadingZerosToHexString() {
        // Assert:
        assertGetStringConversion(
                new byte[]{0x00, 0x00, 0x0d, 0x46, 0x54, 0x57},
                "00000d465457");
    }

    //endregion
}
