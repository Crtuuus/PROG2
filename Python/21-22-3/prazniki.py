import requests
import matplotlib.pyplot as plt

URL = "https://podatki.gov.si/api/3/action/datastore_search?resource_id=eb8b25ea-5c00-4817-a670-26e1023677c6&limit=1000"

data = requests.get(URL).json()
slovar = {leto: [0, 0] for leto in range(2000, 2031)}  # [prazniki, dela_prosti_med_tednom]

for r in data["result"]["records"]:
    leto = int(r["LETO"])
    if leto not in slovar: 
        continue

    slovar[leto][0] += 1  # <-- VSAK zapis je praznik (ključna razlika!)

    if r["DELA_PROST_DAN"].lower() == "da" and r["DAN_V_TEDNU"].lower() not in ("sobota","nedelja"):
        slovar[leto][1] += 1


leta = sorted(slovar.keys())
vsi = [slovar[L][0] for L in leta]
delovni = [slovar[L][1] for L in leta]

plt.figure(figsize=(8,5))
plt.plot(leta, vsi, marker="s", linewidth=1.6, label="Prazniki")
plt.plot(leta, delovni, marker="o", linewidth=1.6, label="Dela prosti dnevi (med tednom)")
plt.xlabel("Leto")
plt.ylabel("Število dni")
plt.legend()
plt.grid(True)
plt.tight_layout()
plt.savefig("holidays.png")  # shrani sliko
plt.show() 