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

import java.text.DecimalFormat;
import java.util.function.Function;

public class FormatUtilsTest {

    private static void assertFiveDecimalPlaceFormatting(final Function<Double, String> format) {
        // Assert:
        Assert.assertThat(format.apply(2.1234), IsEqual.equalTo("2.12340"));
        Assert.assertThat(format.apply(3.2345), IsEqual.equalTo("3.23450"));
        Assert.assertThat(format.apply(5012.0123), IsEqual.equalTo("5012.01230"));
        Assert.assertThat(format.apply(5.0126), IsEqual.equalTo("5.01260"));
        Assert.assertThat(format.apply(11.1234), IsEqual.equalTo("11.12340"));
        Assert.assertThat(format.apply(1.), IsEqual.equalTo("1.00000"));
        Assert.assertThat(format.apply(8.0), IsEqual.equalTo("8.00000"));
    }

    @Test
    public void defaultDecimalFormatFormatsValuesCorrectly() {
        // Arrange:
        final DecimalFormat format = FormatUtils.getDefaultDecimalFormat();

        // Assert:
        Assert.assertThat(format.format(2.1234), IsEqual.equalTo("2.123"));
        Assert.assertThat(format.format(3.2345), IsEqual.equalTo("3.235"));
        Assert.assertThat(format.format(5012.0123), IsEqual.equalTo("5012.012"));
        Assert.assertThat(format.format(5.0126), IsEqual.equalTo("5.013"));
        Assert.assertThat(format.format(11.1234), IsEqual.equalTo("11.123"));
        Assert.assertThat(format.format(1), IsEqual.equalTo("1.000"));
        Assert.assertThat(format.format(8.0), IsEqual.equalTo("8.000"));
    }

    @Test(expected = IllegalArgumentException.class)
    public void decimalFormatCannotBeSpecifiedWithNegativeDecimalPlaces() {
        // Assert:
        FormatUtils.getDecimalFormat(-1);
    }

    @Test
    public void decimalFormatWithZeroDecimalPlacesFormatsValuesCorrectly() {
        // Arrange:
        final DecimalFormat format = FormatUtils.getDecimalFormat(0);

        // Assert:
        Assert.assertThat(format.format(2.1234), IsEqual.equalTo("2"));
        Assert.assertThat(format.format(3.2345), IsEqual.equalTo("3"));
        Assert.assertThat(format.format(5012.0123), IsEqual.equalTo("5012"));
        Assert.assertThat(format.format(5.0126), IsEqual.equalTo("5"));
        Assert.assertThat(format.format(11.1234), IsEqual.equalTo("11"));
        Assert.assertThat(format.format(1), IsEqual.equalTo("1"));
        Assert.assertThat(format.format(8.0), IsEqual.equalTo("8"));
    }

    @Test
    public void decimalFormatWithCustomDecimalPlacesFormatsValuesCorrectly() {
        // Arrange:
        final DecimalFormat format = FormatUtils.getDecimalFormat(5);

        // Assert:
        assertFiveDecimalPlaceFormatting(format::format);
    }

    @Test
    public void formatWithCustomDecimalPlacesFormatsValuesCorrectly() {
        // Assert:
        assertFiveDecimalPlaceFormatting(d -> FormatUtils.format(d, 5));
    }
}
