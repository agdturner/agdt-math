/*
 * Copyright 2020 Centre for Computational Geography, University of Leeds.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package uk.ac.leeds.ccg.math.matrices;

import ch.obermuhlner.math.big.BigRational;
import java.util.Arrays;

/**
 *
 * @author Andy Turner
 */
public class Matrix_BR {

    /**
     * The number of rows in the matrix
     */
    protected final int nr;

    /**
     * The number of columns in the matrix
     */
    protected final int nc;

    /**
     * The matrix.
     */
    protected final BigRational[][] m;

    /**
     * @param nr What {@link #nr} is set to.
     * @param nc What {@link #nc} is set to.
     */
    public Matrix_BR(int nr, int nc) {
        m = new BigRational[nr][nc];
        this.nr = nr;
        this.nc = nc;
    }

    @Override
    public String toString() {
        String r = this.getClass().getSimpleName() + "(nr=" + nr + ", nc=" + nc
                + "\n";
        for (int row = 0; row < nr; row++) {
            for (int col = 0; col < nc; col++) {
                r += "" + m[row][col] + " ";
            }
            r += "\n";
        }
        r += ")";
        return r;
    }

    /**
     * https://en.wikipedia.org/wiki/Matrix_multiplication
     *
     * @param a The matrix to multiply.
     * @param b The matrix to multiply by.
     * @return result of multiplying {@code a} by {@code b}
     */
    public static Matrix_BR multiply(Matrix_BR a, Matrix_BR b) {
        Matrix_BR r = null;
        if (a.nc == b.nr) {
            r = new Matrix_BR(a.nr, b.nc);
            for (int row = 0; row < r.nr; row++) {
                for (int col = 0; col < r.nc; col++) {
                    BigRational v = BigRational.ZERO;
                    for (int i = 0; i < b.nr; i++) {
                        v = v.add(a.m[row][i].multiply(b.m[i][col]));
                    }
                    r.m[row][col] = v;
                }
            }
        }
        return r;
    }

    /**
     * https://en.wikipedia.org/wiki/Transpose
     *
     * @param a The matrix to return the transpose of.
     * @return {@code a} transposed
     */
    public static Matrix_BR transpose(Matrix_BR a) {
        Matrix_BR r = new Matrix_BR(a.nc, a.nr);
        for (int row = 0; row < a.nr; row++) {
            for (int col = 0; col < a.nc; col++) {
                r.m[col][row] = a.m[row][col];
            }
        }
        return r;
    }

    @Override
    public boolean equals(Object o) {
        if (o instanceof Matrix_BR) {
            return equals((Matrix_BR) o);
        }
        return false;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 71 * hash + this.nr;
        hash = 71 * hash + this.nc;
        hash = 71 * hash + Arrays.deepHashCode(this.m);
        return hash;
    }

    public boolean equals(Matrix_BR m) {
        if (nr == m.nr && nc == m.nc) {
            for (int r = 0; r < nr; r++) {
                for (int c = 0; c < nc; c++) {
                    if (this.m[r][c].compareTo(m.m[r][c]) != 0) {
                        return false;
                    }
                }
            }
            return true;
        }
        return false;
    }

}
