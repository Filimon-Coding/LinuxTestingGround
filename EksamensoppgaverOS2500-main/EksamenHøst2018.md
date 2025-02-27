# Eksamen 2018




## 1 Linux kommandolinje

## Hvilken kommando flytter filen /tmp/fil.txt til katalogen du står i?

    mv /tmp/fil.txt .


<br><br>

---


## 1(b)
## Hvilke brukere kan skrive til filen /tmp/secret.txt?
## -rw-r----- 1 haugerud drift 9 Sep 5 15:53 /tmp/secret.txt
   

    -         ---      ---         ---
    filtype   Eier    gruppe  alle andre  


    Kune brukeren Haugerud


<br><br>

---



## Gitt følgende fil med navn index.html:
    $ cat index.html
    <!DOCTYPE html>
    <html itemscope itemtype="http://schema.org/Article" xmlns="http://www.w3.org/1999/xhtml" xml:lang="no"
    lang="no">
    <head>
    <title>Hjem - HiOA</title>
    <meta name="Content-Type" content="text/html; charset=utf-8" />
    <meta name="Content-language" content="no-bokmaal" />
    <meta name="MSSmartTagsPreventParsing" content="TRUE" />
    <meta name="generator" content="eZ Publish" />
    <meta name="title" content="Hjem" />
    <meta itemprop="name" content="Hjem">
    <meta name="author" content="" />
    <meta name="p:domain_verify" content="3a11dc5033d5012ab4dce032cb87920c"/>


## Hvilken kommando gir følgende output?
    $ kommando
    eZ Publish
    Hjem
    Hjem
    3a11dc5033d5012ab4dce032cb87920c


---

    tail -n 5 index.html | grep name | cut -d\" -f 4


<br><br>

---


## Du har en fil biler med følgende innhold:
    $ cat biler
    student bmw 500000
    haugerud berlingo 150000
    kyrre elbil 90000
## Hvilken Linux-kommando fører til følgende resultat?
    $ kommando
    kyrre elbil 90000
    haugerud berlingo 150000
    student bmw 500000

---
    sort -n -k 3 biler


<br><br>
---


## 3(a)

## Forklar kort prinsippene for hvordan et operativsystem fordeler CPU-tid mellom flere samtidige prosesser på en datamaskin med kun en CPU (med en enkelt ALU/kjerne). Forklar spesielt hvordan OS kan la en prosess kjøre direkte på CPUen uten at prosessen kan ta over kontrollen og hindre andre prosesser å kjøre.

    Alle prosesser som ønsker å kjøre blir satt i en roun robin kø der de får tildelt cpu tid også kalt jiffies/time slices. OS plukker da ut en prosess og lar den bruke opp sine tildelte jiffies. Deretter kommer det en context switch og os lar da neste prosess i køen bruke sine jiffies. Får at prosess ikke skal ta over kontrollen så må OS ha hjelp fra hardware i form av en instruksjon kalt trap. Denne switcher modusbit til kernel og hopper til stedet i minne hvor det ligger kode for systemkall. 


--- 
<br><br>

## 3(b)
## Forklar kort hvordan operativsystemet fordeler CPU-tid mellom fem 100% CPU-itensive prosesser som kjører på en Linux server med 4 kjerner/cores (4 uavhengige ALUer). Forklar spesielt omtrent hvor stor CPU-prosent kommandoen top vil vise for hver prosess når alle de fem prosessene kjører samtidig.

    Her fordeler OS scheduleren like mye tid til hver cpu og de vil omtrent få 80% cpu tid hver siden det kun er 4 cores som disse 5 prosessene deler på. 

    4 / 5 = 0,8 = 80%

---
<br><br>

## 3(c)
## Et 100% CPU-avhengig sekvensielt regneprogram bruker 4 minutter når det kjøres på en enkelt CPU-core på en Linux server. Hvis fem slike program startes samtidig på samme server og den totalt har 4 CPU-cores (4 uavhengige ALUer), hvor lang tid tar det før den siste regneprosessene er ferdig? (Ingen andre CPU-krevende prosesser enn disse fem kjøres samtidig)

    (4 * 5) / 4 = 5 = 5 min


---
<br><br>


## Når man ikke bruker fortegn, hva er det største tallet man kan lagre i et 5 bits register?

    1  1 1 1 1
    16 8 4 2 1

    16+8+4+2+1 = 31


---
<br><br>

## 3(e)
## Når en variabel defineres i et C-program som int, settes det av 4 byte til å lagre tallet. Når ett bit brukes til lagre fortegn, hvor stort er det største tallet som kan lagres, uttrykt i potenser av 2? Omtrent hvor stort er dette tallet uttrykt i desimaltall?

    2 147 483 647  



## 3(f)
## Anta at du har følgende C-program med navn sum.c:
```C
#include <stdio.h>
void main()
{
int i, sum = 0;
int N = 40000;
for(i=1;i<=N;i++)
{
    
    sum += i;
}
printf("Sum: %d\n",sum);
}
```

## Forklar kort hva programmet regner ut og hvordan du kompilerer og kjører dette programmet på en Linux server

    Programmet plusser variabelen i med sum 40 000 ganger og skriver ut summen i konsoll.

    man kompilerer c-programmet med gcc sum.c og kan deretter kjøre programmet med ./a.out for å få resultatet.

---

<br><br>


## 3(g)
## Du kjører programmet og får resultatet Sum: 800020000 Så endrer du variabelen N til N = 50000 og får resultatet Sum: 1250025000 og med N = 60000 får du Sum: 1800030000 Til slutt endrer du verdien til N = 70000 og får resultatet Sum: -1844932296
## Forklar kort hva som gjør at beregningene av summen feiler fullstendig på den siste kjøringen med N = 70000 .

    Kort forklart overstiger summen det største tallet en int kan lagre i 32 bit. Derfor blir resultatet feil. Hadde man brukt long istedenfor int hadde men sett riktig resultat ettersom long har 64 bit tilgjengelig i lagring.

---

<br><br


## 3(h)
## Anta at du kjører det opprinnelige C-programmet med N = 40000 på en Linux server med 4 CPU`er. Forklar kort hvorfor operativsystemet ikke kan utnytte flere enn en CPU når dette programmet kjøres for å regne ut resultatet raskere.

    Operativsystemet ikke har noen anelse om hva som foregår i et vilkårlig program. Det bare sørger for at prosessene får utført sine instruksjoner. O perativsystemet kan ikke gjette seg til hva programmet gjør og kan derfor ikke på egenhånd få en enkelt prosess til å utnytte flere prosessorer

   Derfor er det programmereren som eksplisitt må skrive programmet slik at det kjøres som to uavhengige prosesser for at det skal kunne utnytte flere CPU'er. Dette kalles å parallellisere koden

--- 
<br><br>

## 3(i)
## Anta igjen at du har det samme C-program med N = 40000. Du kjører programmet på en Linux server med 4 CPUer. Forklar kort hvordan du som programmerer kan endre programmet slik at operativsystemet kan utnytte alle de fire CPU`ene når dette programmet kjøres for å regne ut resultatet nesten fire ganger raskere (ikke skriv kode, men forklar hvordan du i prinsippet vil endre programmet).

    Som programmerer kan jeg parallellisere koden sånn at den kjøres som flere uavnhengige prosesser. Man kan f eks summere alle tall fra på en cpu fra 1 - 10 000, den andre cpu`en kan ta alle tall fra 10 001 - 20 000, tredje cpu ta alle fra 20 001 - 30 000 og siste cpu tar disse 30 001 til 40 000 også legge summen sammen på slutten.

---
<br><br>

## 3(j)
## Anta at du har et C-program som regner ut Fibonacci-rekken: 1, 1, 2, 3, 5, 8, 13, 21, 34, 55, ..... så langt som mulig. I denne rekken er neste tall summen av de to foregående. Forklar kort hvorfor du som programmerer ikke kan endre dette programmet slik at det kan utnytte alle fire CPU´er på en Linux server for å regne ut resultatet raskere.

     Neste ledd i beregningen avhenger av det forrige og det tar uforholdsmessig lang tid å flytte verdier av registre fra en CPU til en annen. I dette tilfellet lar ikke algoritmen seg naturlig dele opp i separate bergningsdeler og da vil det også være vanskelig for en programmerer å dele opp beregningen i flere prosesser for å utnytte flere prosessorer


---
<br><br>

## Internminne

## 4(a)

    
