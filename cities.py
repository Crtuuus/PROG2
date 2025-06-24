# cities_basemap.py

import requests
import matplotlib
matplotlib.use('Agg')            # non‐GUI backend
import matplotlib.pyplot as plt
from mpl_toolkits.basemap import Basemap
import random

def main():
    # 1) Naloži seznam mest
    url = "https://lovro.fri.uni-lj.si/api/cities"
    resp = requests.get(url, timeout=10)
    resp.raise_for_status()
    cities = resp.json()

    # 2) Pripravi sezname lat/lon in barv po državi
    lats = [float(c["lat"]) for c in cities]
    lons = [float(c["lng"]) for c in cities]
    countries = {c["country"] for c in cities}
    country_colors = {
        co: (random.random(), random.random(), random.random())
        for co in countries
    }
    colors = [country_colors[c["country"]] for c in cities]

    # 3) Ustvari Basemap projekcijo (Mercator) in zemljevid
    fig = plt.figure(figsize=(16, 9))
    m = Basemap(
        projection='merc',
        llcrnrlat=-60, urcrnrlat=80,
        llcrnrlon=-180, urcrnrlon=180,
        lat_ts=20, resolution='l'
    )
    m.drawcoastlines(linewidth=0.5)
    m.drawcountries(linewidth=0.3)
    m.fillcontinents(color='#dddddd', lake_color='white')
    m.drawmapboundary(fill_color='white')

    # 4) Pretvori geografske koordinate v projekcijske x,y
    x, y = m(lons, lats)

    # 5) Scatter mestnih točk
    m.scatter(
        x, y,
        marker='.',
        s=2,
        c=colors,
        alpha=0.8,
        edgecolors='none',
        zorder=5
    )

    # 6) (neobvezno) Legenda ali naslov
    plt.title("World Cities Map", fontsize=18, fontweight='bold')

    # 7) Shrani
    out = "cities_basemap.png"
    fig.savefig(out, dpi=200, bbox_inches='tight', pad_inches=0)
    plt.close(fig)
    print(f"✅ Zemljevid shranjen kot {out}")

if __name__ == "__main__":
    main()
