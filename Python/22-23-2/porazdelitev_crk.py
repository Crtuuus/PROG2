import matplotlib.pyplot as plt

ALPHABET = "abcdefghijklmnopqrstuvwxyz"

# 1) imena datotek v isti mapi kot skripta
datoteke = ["Frankenstein.txt", "Moby Dick.txt", "Peter Pan.txt"]
# če so imena drugačna, jih tukaj popravi

def prazni_stevci():
    d = {ch: 0 for ch in ALPHABET}
    d["_total"] = 0
    return d

rezultati = {}  # {label: slovar_stevcev}

# 2) glavna zanka čez knjige
for fname in datoteke:
    with open(fname, "r", encoding="utf-8", errors="ignore") as f:
        besedilo = f.read().lower()

    stevci = prazni_stevci()

    # 3) zanka čez znake; štejemo samo angleške črke
    for c in besedilo:
        if c in ALPHABET:
            stevci[c] += 1
            stevci["_total"] += 1

    rezultati[fname.replace(".txt", "")] = stevci  # lepo ime za legendo

# 4) risanje grafa relativnih frekvenc
x = list(range(len(ALPHABET)))
plt.figure(figsize=(7, 6))

for label, s in rezultati.items():
    total = s["_total"] or 1  # zaščita pred deljenjem z 0
    frekvence = [s[ch] / total for ch in ALPHABET]
    plt.plot(x, frekvence, label=label)

plt.xticks(x, list(ALPHABET))
plt.xlabel("črka")
plt.ylabel("relativna frekvenca")
plt.title("Porazdelitev črk")
plt.legend()
plt.tight_layout()
plt.savefig("letters.pdf")
print("Shranjeno v letters.pdf")
