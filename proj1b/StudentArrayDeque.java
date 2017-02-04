public class StudentArrayDeque<T> {
    private Object[] a = (Object[]) (new Object[8]);
    private int b = 8;
    private int c = 0;
    private int d = 4;
    private int e = 4;
    private int f = 5;
    private boolean g = false;
    private boolean h = false;

    public StudentArrayDeque() {
    }

    public void addFirst(Object var1) {
        this.a();
        if (this.e >= 0) {
            this.a[this.e] = var1;
            --this.e;
        } else {
            this.a[this.a.length - 1] = var1;
            this.e = this.a.length - 1 - 1;
            this.h = true;
        }

        ++this.c;
    }

    public void addLast(Object var1) {
        this.a();
        if (this.f < this.a.length) {
            this.a[this.f] = var1;
            ++this.f;
        } else {
            this.a[0] = var1;
            this.f = 1;
            this.g = true;
        }

        ++this.c;
    }

    public T removeFirst() {
        this.a();
        if (this.c == 0) {
            return null;
        } else {
            --this.c;
            Object var1;
            if (this.e != this.d) {
                if (this.e == this.a.length - 1) {
                    var1 = this.a[0];
                    this.e = 0;
                    this.h = false;
                    return (T) var1;
                } else {
                    var1 = this.a[this.e + 1];
                    ++this.e;
                    return (T) var1;
                }
            } else if (this.h) {
                var1 = this.a[this.e + 1];
                ++this.e;
                if (this.e == this.a.length) {
                    this.h = false;
                    this.e = 0;
                }

                return (T) var1;
            } else if (this.e == this.a.length - 1) {
                var1 = this.a[0];
                this.e = 0;
                this.d = 0;
                this.g = false;
                return (T) var1;
            } else {
                var1 = this.a[this.d + 1];
                this.e = this.d + 1;
                ++this.d;
                this.h = false;
                return (T) var1;
            }
        }
    }

    public T removeLast() {
        this.a();
        if (this.c == 0) {
            return null;
        } else {
            --this.c;
            Object var1;
            if (this.f != 1 + this.d) {
                if (this.f == 0) {
                    var1 = this.a[this.a.length - 1];
                    this.f = this.a.length;
                    this.g = false;
                    return (T) var1;
                } else {
                    var1 = this.a[this.f - 1];
                    --this.f;
                    if (this.f == 0) {
                        this.g = false;
                        this.f = this.a.length;
                    }

                    return (T) var1;
                }
            } else if (this.g) {
                var1 = this.a[this.f - 1];
                --this.f;
                if (this.f <= 0) {
                    this.g = false;
                    this.f = this.a.length - 1;
                }

                return (T) var1;
            } else if (this.f == 0) {
                var1 = this.a[this.a.length - 1];
                this.a[this.a.length - 1] = null;
                this.f = this.a.length - 1;
                return (T) var1;
            } else {
                var1 = this.a[this.d];
                this.f = this.d--;
                this.g = false;
                return (T) var1;
            }
        }
    }

    public void printDeque() {
        if (this.c != 0) {
            int var1;
            if (this.e <= this.d + 1) {
                for (var1 = this.e + 1; var1 < this.d + 1; ++var1) {
                    System.out.print(this.a[var1] + " ");
                }
            } else {
                for (var1 = this.e; var1 < this.a.length; ++var1) {
                    System.out.print(this.a[var1] + " ");
                }

                for (var1 = 0; var1 < this.d + 1; ++var1) {
                    System.out.print(this.a[var1] + " ");
                }
            }

            if (this.f < this.d) {
                for (var1 = this.f; var1 >= 0; --var1) {
                    System.out.print(this.a[var1] + " ");
                }

                for (var1 = this.a.length - 1; var1 >= this.d + 1; --var1) {
                    System.out.print(this.a[var1] + " ");
                }
            } else {
                for (var1 = this.d + 1; var1 < this.f; ++var1) {
                    System.out.print(this.a[var1] + " ");
                }
            }
        }

        System.out.println();
    }

    public boolean isEmpty() {
        return this.c == 0;
    }

    public int size() {
        return this.c;
    }

    private void a() {
        Object[] var1;
        if (((double) (this.c / this.b) <= 0.5D || this.b < 16) && this.c + 1 != this.b) {
            if (this.c == 0) {
                var1 = (Object[]) (new Object[8]);
                this.e = 4;
                this.f = 5;
                this.a = var1;
                this.b = 8;
                this.c = 0;
                this.d = 4;
            } else {
                if ((double) this.c / (double) this.b < 0.25D && this.b > 16) {
                    int var6;
                    Object[] var7 = (Object[]) (new Object[var6 = this.b / 2]);
                    System.arraycopy(this.a, this.e + 1, var7,
                            var6 / 2 - (this.d - this.e) + 1, this.d - this.e);
                    this.e = var6 / 2 - (this.d - this.e);
                    System.arraycopy(this.a, this.d + 1, var7, var6 / 2 + 1, this.f - this.d - 1);
                    int var8 = 1;
                    int var9 = 2;
                    this.f = (var6 / 2 + (this.f - this.d - 1) + 1) ^ (var8 << var9);
                    this.a = var7;
                    this.b = var6;
                    this.d = var6 / 2;
                }

            }
        } else {
            var1 = (Object[]) (new Object[this.b << 2]);
            int var2;
            int var3;
            int var4 = (var3 = (var2 = 4 * this.b) / 2) + 1;
            this.h = false;
            this.g = false;
            int var5;
            if (this.e > this.d) {
                for (var5 = this.d; var5 >= 0; --var5) {
                    var1[var3] = this.a[var5];
                    --var3;
                }

                for (var5 = this.a.length - 1; var5 > this.e; --var5) {
                    var1[var3] = this.a[var5];
                    --var3;
                }
            } else {
                for (var5 = this.d; var5 > this.e; --var5) {
                    var1[var3] = this.a[var5];
                    --var3;
                }
            }

            if (this.f < this.d + 1) {
                for (var5 = this.d + 1; var5 < this.a.length; ++var5) {
                    var1[var4] = this.a[var5];
                    ++var4;
                }

                for (var5 = 0; var5 < this.f; ++var5) {
                    var1[var4] = this.a[var5];
                    ++var4;
                }
            } else {
                for (var5 = this.d + 1; var5 < this.f; ++var5) {
                    var1[var4] = this.a[var5];
                    ++var4;
                }
            }

            this.a = var1;
            this.e = var3;
            this.f = var4;
            this.b = var2;
            this.d = this.b / 2;
        }
    }

    public T get(int var1) {
        if (var1 + 1 > this.c) {
            return null;
        } else if (this.h) {
            if (this.e + var1 + 1 < this.a.length) {
                return (T) this.a[this.e + var1 + 1];
            } else {
                var1 -= this.a.length - this.e - 1;
                return (T) this.a[var1];
            }
        } else if (this.g && this.e + var1 + 1 >= this.a.length) {
            var1 -= this.a.length - this.e - 1;
            return (T) this.a[var1];
        } else {
            return (T) this.a[this.e + var1 + 1];
        }
    }
}
