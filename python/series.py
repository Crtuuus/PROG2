class Series:
    def __init__(self, a_n):
        """
        a_n: funkcija, ki za dano n vrne n-ti člen zaporedja.
        """
        self.a_n = a_n

    def s_n(self, n=1):
        """Vsota prvih n členov (privzeta: prešteješ jih enega za drugim)."""
        return sum(self.a_n(k) for k in range(1, n+1))


class Arithmetic(Series):
    def __init__(self):
        # a(n) = 0.001 * n
        super().__init__(lambda n: 0.001 * n)


class Geometric(Series):
    def __init__(self):
        # a(n) = 0.9 ** n
        super().__init__(lambda n: 0.9 ** n)


class Harmonic(Series):
    def __init__(self):
        # a(n) = 1 / n
        super().__init__(lambda n: 1 / n)


for series in [Arithmetic(), Geometric(), Harmonic()]:
    for n in [1, 10, 100, 1000]:
        print("a({}) = {:.3f}\ts({}) = {:.3f}".format(n, series.a_n(n), n, series.s_n(n)))
    print()