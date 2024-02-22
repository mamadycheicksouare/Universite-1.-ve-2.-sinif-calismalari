# MAMADY CHEICK SOUARE 20100011002

players = {}


def veri_al():
    with open("20100011002.txt", "r", encoding="utf-8") as mamady:
        satirlar = mamady.readlines()
        for i in satirlar:
            spsatir = i.split(" ")
            didd = int(spsatir[0])
            dname = spsatir[3]
            dname = dname[1:(len(dname) - 2)]
            dage = spsatir[5]
            dage = dage[: - 1]
            dage = int(dage)
            dmaas = spsatir[7]
            dmaas = dmaas[: - 1]
            dmaas = int(dmaas)
            dmacsayi = spsatir[9]
            dmacsayi = dmacsayi[: - 1]
            dmacsayi = int(dmacsayi)
            dskor = spsatir[11]
            dskor = dskor[:-2]
            dskor = int(dskor)
            players[didd] = {"ad": dname, "yas": dage, "maas": dmaas, "macsayi": dmacsayi, "skor": dskor}


veri_al()


def ekleme():
    adet = int(input("Ana menu-----> 0\nKac oyuncu gireceksiniz ------> "))
    while adet == 0:
        break
    for i in range(adet):
        a = list(players.keys())
        if len(a) == 0:
            idd = 1
        else:
            idd = max(a) + 1

        ad = input("{}. Oyuncunun adi giriniz ------> ".format(i+1))
        yas = int(input("{}.Oyuncunun yasi giriniz ------> ".format(i+1)))
        maas = int(input("{}.Oyuncunun maasi TL olarak giriniz ------> ".format(i+1)))
        macsayi = int(input("{}.Oyuncunun macsayi giriniz ------> ".format(i+1)))
        skor = int(input("{}.Oyuncunun skor sayi giriniz ------> ".format(i+1)))

        players[idd] = {"ad": ad, "yas": yas, "maas": maas, "macsayi": macsayi, "skor": skor}
        print("Oyuncu eklendi")

        def yazma():
            with open("20100011002.txt", "w", encoding="utf-8") as mamady:
                for k in list(players.keys()):
                    mamady.write(str(k))
                    mamady.write(" : ")
                    mamady.write(str(players[k]))
                    mamady.write("\n")

        yazma()
        idd += 1


def ortayas_maasbul():
    if len(list(players.keys())) < 1:
        print("Ortalama yas ve maas hesaplanamaz kayitli oyuncu yok")
    else:
        tyas = 0
        tmaas = 0
        for i in list(players.keys()):
            tyas = tyas + players[i]["yas"]
            tmaas = tmaas + players[i]["maas"]

        ortayas = tyas / len(list(players.keys()))
        ortamaas = tmaas / len(list(players.keys()))
        ortayas = round(ortayas, 2)
        ortamaas = round(ortamaas, 2)
        print("Ortalama yas -----------> {}   ".format(ortayas))
        print("Ortalama maas ------>{} TL".format(ortamaas))


def katkilar():
    if len(list(players.keys())) < 1:
        print("Katkilar hesaplanamaz kayitli oyuncu yok")
    else:
        for i in list(players.keys()):
            if players[i]["macsayi"] == 0:
                katki = 0
            else:
                katki = (players[i]["skor"])/(players[i]["macsayi"])
                katki = round(katki, 2)
            print("{} : {}".format(players[i]["ad"], katki))


def silme():
    print(list(players.keys()))
    splayer = int(input("Ana menu----->0\nHangi oyuncu silmek istiyorsunuz--------> "))

    if splayer not in (list(players.keys()) + [0]):
        print("Girdiginiz bulunmamaktadir")

    if splayer in list(players.keys()):
        players.pop(splayer)
        print("Oyuncu silindi\n")

        def yazma():
            with open("20100011002.txt", "w", encoding="utf-8") as mamady:
                for k in list(players.keys()):
                    mamady.write(str(k))
                    mamady.write(" : ")
                    mamady.write(str(players[k]))
                    mamady.write("\n")

        yazma()

    while splayer == 0:
        break


def arama():

    print(list(players.keys()))
    aplayer = int(input("Ana menu----->0\nHangi oyuncu aramak istiyorsunuz--------> "))

    if aplayer in list(players.keys()):
        print(players[aplayer])

    if aplayer not in (list(players.keys()) + [0]):

        print("Aradiginiz bulunmamaktadir")
    while aplayer == 0:
        break


def guncelleme():
    print(list(players.keys()))
    gplayer = int(input("Ana menu----->0\nHangi oyuncuyu guncellemek istiyorsunuz--------> "))

    if gplayer in list(players.keys()):
        print(players[gplayer].keys())
        bilgi = input("Hangi bilgi guncellemek istiyorsunuz------> ")
        if bilgi == 'ad':
            yenideger = input("Yeni adi giriniz -------->")
        else:
            yenideger = int(input("Yeni deger giriniz"))
        players[gplayer][bilgi] = yenideger
        print("Guncelleme yapildi ")

        def yazma():
            with open("20100011002.txt", "w", encoding="utf-8") as mamady:
                for k in list(players.keys()):
                    mamady.write(str(k))
                    mamady.write(" : ")
                    mamady.write(str(players[k]))
                    mamady.write("\n")
        yazma()

    if gplayer not in (list(players.keys()) + [0]):
        print("Girdiginiz bunlmamaktadir")

    while gplayer == 0:
        break


while True:
    secim = input("------------------------------------------------------------------------------------\n"
                  "1- Oyuncu ekleme\n2- Guncelleme\n3- Oyuncu silme\n4- Oyuncu arama\n5- "
                  "Ortalama yas ve maas\n6- Katkilar\n7- Cikis\n"
                  "------------------------------------------------------------------------------------\n")
    if secim == "1":
        ekleme()
    if secim == "2":
        guncelleme()
    if secim == "3":
        silme()
    if secim == "4":
        arama()
    if secim == "5":
        ortayas_maasbul()
    if secim == "6":
        katkilar()
    if secim == "7":
        break
    else:
        continue
