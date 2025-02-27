# Høst 2017

# Linux Kommando

## 1(a)
## Hvilken Linux-kommando gir deg hvilken katalog du står i?

## Velg ett alternativ
* pwd 
* chmod 
* mkdir 
* ls 
* touch 
* ps
* cd 
* cat

### **PWD er riktig svar**

---

<br><br>

## 1(b)
## Hvilken linux-kommando linster prosesser?

## Velg et alternativ 
* less
* more
* ls
* pwd
* cat
* ps
* proc
* list 

### **PS er riktig svar**


---
<br><br>

## 1(c)

## Nedenfor er åtte Linux-kommandoer listet opp i hver sin kolonne. Merk av hva de betyr i hver av radene.


|                      | chmod | mv | ln | rm | cat | cp | mkdir | ls |   |
|----------------------|-------|----|----|----|-----|----|-------|----|---|
| Lag link             |       |    | *  |    |     |    |       |    |   |
| Skriv til stdout     |       |    |    |    | *   |    |       |    |   |
| Lag mappe            |       |    |    |    |     |    | *     |    |   |
| Kopier               |       |    |    |    |     | *  |       |    |   |
| Flytt                |       | *  |    |    |     |    |       |    |   |
| Endre rettigheter    | *     |    |    |    |     |    |       |    |   |
| List innhold i mappe |       |    |    |    |     |    |       | *  |   |
| Slett/fjern          |       |    |    | *  |     |    |       |    |   |


---

<br><br>

# Bash-scripting


## 2(a) 
## Les først Bash-scripting; info-side og skriv ned en ping-kommando som tilsvarer den på info-siden, men som
## sender et nytt ping med 5 sekunders mellomrom til www.hin.no, istedet for ett sekunds mellomrom som er default
## verdi.

```bash
ping -i 5 www.hin.no
```

---
<br><br>

## 2(b)
## Les først Bash-scripting; info-side og skriv så en ping-kommando som kun sender en enkelt ping-pakke til www.hin.no og dermed gir output som vist under:
```bash
$ DIN PING-KOMMANDO
PING www.hin.no (129.242.5.168) 56(84) bytes of data.
64 bytes from hin.no (129.242.5.168): icmp_seq=1 ttl=55 time=21.5 ms
--- www.hin.no ping statistics ---
Words: 0
Maks poeng: 10
 3/19
                                
DATS/ITPE2500 kont 2017
1 packets transmitted, 1 received, 0% packet loss, time 0ms rtt min/avg/max/mdev = 21.527/21.527/21.527/0.000 ms

```

```bash
ping -c 1 www.hin.no


--- www.hin.no ping statistics ---
1 packets transmitted, 1 received, 0% packet loss, time 0ms
rtt min/avg/max/mdev = 22.243/22.243/22.243/0.000 ms
```

--- 

<br><br>

## 2(c)
## Les først Bash-scripting; info-side og skriv så en ping-kommando som kun sender en enkelt ping-pakke til www.hin.no hvor ttl (IP Time to Live) verdien er satt lik 1 og dermed gir output som vist under:

```bash

$ DIN PING-KOMMANDO
PING www.hin.no (129.242.5.168) 56(84) bytes of data.
From hioa-gw1.hioa.no (128.39.74.1) icmp_seq=1 Time to live exceeded
--- www.hin.no ping statistics ---
1 packets transmitted, 0 received, +1 errors, 100% packet loss, time 0ms

```

# Svar

```bash

ping -t 1 -c 1 www.hin.no
PING www.hin.no (129.242.5.168) 56(84) bytes of data.
From cs-fw1.oslomet.no (10.196.10.1) icmp_seq=1 Time to live exceeded

--- www.hin.no ping statistics ---
1 packets transmitted, 0 received, +1 errors, 100% packet loss, time 0ms
```

---
<br><br>

## 2(d)
## I forrige oppgave ble ttl satt til 1. Hver gang en IP-pakke når en ruter, vil verdien på ttl som er lagret i pakkens header minskes med en. Når ttl settes til verdien 1 i en pakke som sendes, vil den første ruteren minske verdien til 0. Det betyr at pakken skal droppes og ruteren kaster da pakken og sender en melding til avsenderen om "Time to live exceeded". I vårt tilfelle er HiOA-ruteren hioa-gw1.hioa.no den første ruteren pakken kommer til.

## Skriv igjen en ping-kommando som sender en enkelt ping-pakke til www.hin.no hvor ttl verdien er satt lik 1, men som velger ut kun en av linjene fra ping-kommandoen og som dermed gir output som vist under:

## $ DIN PING-KOMMANDO

## From hioa-gw1.hioa.no (128.39.74.1) icmp_seq=1 Time to live exceeded

## Skriv ned DIN PING-KOMMANDO:
```bash 
sxxxxxx@data2500:~$ ping -t 1 -c 1 www.hin.no | grep "Time to live " 
From cs-fw1.oslomet.no (10.196.10.1) icmp_seq=1 Time to live exceeded
```


---
<br><br>

## 2(e)
## Hvis man øker ttl-verdien til 2 når man sender en ping-pakke, vil ttl-verdien senkes til 1 av hioa-gw1.hioa.no og så senkes til 0 av neste ruter på veien mot målet. Denne ruteren sender så en "Time to live exceeded" pakke tilbake til avsender.
## Skriv igjen en ping-kommando som sender en enkelt ping-pakke til www.hin.no, men hvor ttl verdien er satt lik 2, og som igjen velger ut kun en av linjene fra output og som dermed gir output som vist under:
    $ DIN PING-KOMMANDO
    From pil32-gw.uninett.no (158.36.84.53) icmp_seq=1 Time to live exceeded
## Skriv ned DIN PING-KOMMANDO:

## Svar

    ping -c 1 -t 2 www.hin.no | grep "Time to live exceeded"

# C og Assembly

## 3(a)
## Anta at du har et C-program som heter add.c. Skriv ned kommandoen, eventuelt kommandoene, du må utføre for å kjøre dette programmet på en Linux-maskin.

```bash
gcc add.c for å kompilere 
./a.out for å kjøre
```


---
<br><br>

## 3b
## Anta at add.c har følgende innhold. Hva blir output fra programmet når du kjører det?

```C
#include <stdio.h>
int main(void)
{
int felles = 13;
int tall = 29;
felles = felles + tall; 
printf("Resultat: %d\n",felles);
}
```

# Svar

### **Resultat: 42**

---
<br><br>

## 3(c)

## Du kompilerer så programmet med
    $ gcc -S add.c

## og den vesentligste delen av den resulterende filen add.s ser slik ut:
```assembly
    movl $13, -8(%rbp)
    movl $29, -4(%rbp)
    movl -4(%rbp), %eax
    addl %eax, -8(%rbp)
```
## Forklar kort hva som skjer når disse fire instruksjonene utføres. Hvilket tall er resultatet etter at disse har blitt kjørt og hvor ligger tallet lagret?

### **1 movl instruksjon flytter tallet 13 til RAM rbp plass 8 fra toppen**
### **2 movl instruksjon flytter tallet 29 til RAM  rbp plass 4 fra toppen**
### **3 movl instruksjon flytter tallet 29 til eax registeret.**
### **4 addl instruksjonen legger til 29 på adressen i RAM der 13 ligger fra før så resultatet blir 42**

---
<br><br>

## 3(d)
## Forklar hvilken eller hvilke assembly-instruksjoner som C-instruksjonen
##   felles = felles + tall;
## leder til i add.s. Forklar kort om en C-instruksjon nødvendigvis leder til bare en enkelt Assembly-instruksjon og om en Assembly-instruksjon tilsvarer en enkelt maskin-instruksjon i den binære kjørbare koden.

    En linje med høynivå-kode kan lede til flere linjer lavnivå-kode. x86 instruksjonene kan ikke jobbe på to referanser i minnet samtidig. Dette fører til at det kan kreve flere linjer med assembly kode enn C kode for å gjøre samme instruksjon. Assembly har typisk et 1 til 1 forhold med maskinkode hvor èn linje assembly fører til 1 linje maskinkode. 


---
<br><br>

## 3(e)
## Du kompilerer nå add.c med opsjonen -O
    $ gcc -O -S add.c
## og de fire linjene som add.s tidligere inneholdt blir nå erstattet av en enkelt linje:
    movl $42, %edx
## Forklar kort hva som har skjedd og hvorfor opsjonen -O fører til at kompilatoren lager denne koden istedet.

    Når du bruker opsjonen -O vil koden bli optimalisert. Det vil si at koden blir gjort så hurtig som mulig og kompilatoren er smart nok til å vite resultatet av utregningen, så istedenfor å bruke to registere i ram for å lagre svarene blir verdien lagt inn i %edx med en gang. Så i løpet av kompileringen hopper kompilatoren over utrengningen og legger svaret direkte inn i en variabel.


---
<br><br>

# Serialisering og Mutex
## 4(a) 

## Hva er et kritisk avsnitt?

## Velg ett alternativ
* Kode som er nødvendig for at deler av OS-kjernen skal kunne serialiseres
* Kode som avgjør om en prosess skal avsluttes på grunn av en deadlock
* Kode som en prosess kun kan utføre når CPU'en har switchet modus bit til priviligert modus 
* Kode som må utføres veldig hurtig for at en trap til OS-kjernen ikke skal ta for lang tid
* Kode som må fullføres uten at andre prosesser bruker samme felles ressurs
* Kode i OS-kjernen som utfører en context switch

# Svar

### **Kode som må fullføres uten at andre prosesser bruker samme felles ressurs**

---

<br><br>

## 4 (b)
# Serialisering og Mutex
# Hva er en context switch?

* En hardware-switch som peker ut den neste prosessen som skal kjøre
* At OS skifter prosess som bruker CPU'en
* At OS går inn i et kritisk avsnitt
* En opsjon man bruker når et program starter, slik at det velger riktig kontekst
* At prosessor-modus skifter mellom bruker-modus og priviligert-modus
* En oppgradering av OS-kjernen

# Svar

### **At OS skifter prosess som bruker CPU'en**
---

<br><br>

## 4(c)
## Forklar kort hvorfor serialisering av prosesser er nødvendig i et multitasking operativsystem.


     Serialisering er nødvendig for et mutitasking os fordi det forhindrer at flere prosesser som kjører samtidig endrer på verdiene i oppgaver den prosesen ikke har noe med å gjøre. Uten serialisering kunne det ikke eksistere mulittasking OS ettersom det hadde blitt for mange feil og ingen riktig resultater fra prosessene. 

--- 
<br><br>

## 4(d)
##  Anta at du har et multitasking system med en singel prosessor med to samtidige tråder T0 og T1 som deler en felles variabel med navn felles. I høynivåkoden for T0 forekommer linjen
    felles = felles + tall;
## mens linjen
    felles = felles - tall;
## forekommer i koden for T1 . Forklar hva som kan gå galt hvis disse  kode-linjene blir utført samtidig. Henvis gjerne til koden og dine svar i oppgaven "C og Assembly

    Noe som kan skje hvis prosessene ikke er serialisert er at prosessene kan oppdatere felles variabel før den andre har hatt mulighet til å gjøre sin utregning og oppdaterer variablen. Det dette fører til er forksjellige svar hver gang etter utregningen er ferdig. 

--- 

<br><br>

## 4(e)
## Forklar hvordan problemet i 4(d) kan unngås om prosessene har tilgjengelig en felles variabel lock og to mutex prosedyrer Get_Mutex(lock) og Release_Mutex(lock) og vis konkret hvordan koden for T0 og T1 må endres.

    Problemet unng ̊as ved at prosessene utelukker hverandre ved  ̊a bruke mutex-funksjonene, da serialiseres utføringen av tr ̊adene og man er sikker p a at en race condition ikke oppst ̊ar. Koden for henholdsvis T0 og T1 blir:
    Get_Mutex(lock);
    felles = felles + tall;
    Release_Mutex(lock);
    Get_Mutex(lock);
    felles = felles - tall;
    Release_Mutex(lock);
---

<br>
<br>

## 4(f)
## Tenk deg at trådene T0 og T1 har tid (thread ID) 0 og 1 henholdsvis. Betrakt følgende implementasjon av mutex-
funksjonene:

```Java
int turn = 0; // Felles variabel som begge tråder har tilgang til
void Get_Mutex (int tid){ 
    while (turn != tid) { 

    }
}
Release_Mutex (int tid){ 
    turn = 1 - tid;
}
```

## Forklar hvordan T0 og T1 skal bruke disse funksjonene og hvorfor de virker. Hva er den største ulempen med denne implementasjonen av mutex-funksjonene (for eksempel sammenlignet med Peterson-algoritmen) ? 
<br>

# Svar 

    Dette burde sikre at to prosesser ikke er i kritisk avsnitt samtidig? Men hva om det skjer en Context Switch rett etter while(lock){} når P1 kjører? Da rekker ikke P1 å sette lock til true og P2 kunne gå inn i kritisk avsnitt, switches ut og P1 kan gå inn i kritisk avsnitt samtidig! Altså er ikke denne metoden korrekt. Dette er vanskelig å løse med en algoritme, som forsøkene i ukens oppgaver viser. Men Peterson-algoritmen gir en elegant løsning.

---

<br><br>

# Powershell
## 5(a)

## I PowerShell kan man, akkurat som i et bash-shell, sende output fra en kommando til en annen kommando ved hjelp av en pipe. For eksempel er
    ls | sort
## en gyldig kommando i begge tilfeller. Hva er den viktigste forskjellen på det som sendes igjennom en pipe når man sammenligner PowerShell og bash?

<br>

### Velg ett alternativ

* I PowerShell krypteres alt som sendes slik at overføringen er sikrere
* I bash er denne teknologien mer avansert fordi den har blitt utviklet gjennom 40 år
* I PowerShell sendes også ikoner, noe som egner seg bedre i et grafisk brukergrensesnitt
* I PowerShell sendes hele objekter med metoder og egenskaper
* I bash kan informasjonen sendes til andre kanaler, som stderr og /dev/null
* I bash komprimeres informasjonen som sendes slik at det går raskere

# 
    Svar:  I PowerShell sendes hele objekter med metoder og egenskaper

---

<br>
<br>

## 5(b)
## I PowerShell gjør du følgende kommando:

```Powershell
PS C:\Users\evav\mydir> ls Directory: C:\Users\evav\mydir
Maks poeng: 10
Mode ---- -a----
LastWriteTime Length Name ------------- ------ ----
22.06.2017 21.14 26807 dok.pdf
Words: 0
Maks poeng: 20
-a---- 01.12.2015 08.24 59481 License.pdf
14/19
DATS/ITPE2500 kont 2017
-a---- 26.06.2017 11.15 609017 Room.pdf
```

## Hvilken av de følgede kommandoene vil gi
    dok.pdf
## som output?

## Velg ett alternativ

* ls.dok.pdf.Name
* ls | grep dok.pdf Get-Name $(ls dok.pdf) ls *.pdf
* (ls dok.pdf).Name
* ls dok.pdf
* ls | grep dok.pdf | cut -f 5

#

    svar: (ls dok.pdf).Name

---
<br>
<br>

## 5(c)
## I PowerShell er det laget en rekke alias som gjør det enkelt for en som kjenner til Linux-kommandoer å bruke de samme kommandoene i PowerShell. Merk av hvilke Linux-kommandoer som tilsvarer hvilke PowerShell Cmdlets.

## Finn de som passer sammen

    |                | ls | cp | ps | mv | kill | cat | echo | pwd |
    |----------------|----|----|----|----|------|-----|------|-----|
    | Stop- Process  |    |    |    |    | *    |     |      |     |
    | Move- Item     |    |    |    | *  |      |     |      |     |
    | Write- Output  |    |    |    |    |      |     | *    |     |
    | Get- Process   |    |    | *  |    |      |     |      |     |
    | Get- Location  |    |    |    |    |      |     |      | *   |
    | Get- ChildItem | *  |    |    |    |      |     |      |     |
    | Copy- Item     |    | *  |    |    |      |     |      |     |
    | Get- Content   |    |    |    | *  |      | *   |      |     |

---
<br><br>

## 5(d)
## Anta at du ønsker å få en kronologisk samling av alle dine pdf-dokumenter på din Windows 10 PC. Skriv et
## PowerShell script pdf.ps1 som kopierer alle dokumenter med fil-endelse .pdf under C:\ (inkludert alle
## undermapper) til en mappe-struktur i den tomme mappen C:\pdf. Du kan anta at scriptet vil kjøres med
## administrator-rettigheter. Mappe-strukturen skal lages underveis av scriptet. For eksempel skal
## dokumentet dok.pdf laget i måned 7 i året 2017 kopieres til mappen C: \pdf\Y2017\M7 mens ett laget i måned 4 i
## 2016 skal kopieres til C:\pdf\Y2016\M4. Hvis en mappe det er behov for ikke eksisterer fra før skal den lages av
## scriptet. Før du lager scriptet, tester du ut noen kommandoer som kan gi nyttig informasjon:

```Powershell
PS C:\Users\evav\mydir> $fil = ls dok.pdf
PS C:\Users\evav\mydir> $fil.CreationTime
Torsdag 6. juli 2017 15.26.46
PS C:\Users\evav\mydir> $fil.CreationTime.Month
7
PS C:\Users\evav\mydir> $fil.CreationTime.Year
2017
PS C:\Users\evav\mydir> $fil.Extension
.pdf
PS C:\Users\evav\mydir> Test-Path C:\Users
True
PS C:\Users\evav\mydir> Test-Path C:\pdf
False
 PS C:\Users\evav\mydir> mkdir Y2015
Directory: C:\Users\evav\mydir

 Mode LastWriteTime Length Name
---- ------------- ------ ----
d----- 06.07.2017 19.12 Y2015
```

# Svar
```Powershell
$dir = "C:\pdf"
if( ! (test-path $dir)){
mkdir $dir }
foreach ($fil in ls -r C:\){
   if($fil.extension -eq ".pdf"){
      $m = $fil.CreationTime.Month
      $y = $fil.CreationTime.Year
      $d = "$dir\Y$y\M$m"
      if( ! (test-path $d)){
mkdir $d }
      cp $fil.FullName $d
   }
}

```

---
<br><br>

# INTERNMINNE
## 6(a)
## Hva er betydningen av begrepet Random Access Memory?
## Velg ett alternativ

* At det er tilfeldig hvilken byte som hentes først om to byte leses samtidig 
* At det tar like lang tid å hente en byte fra hvor som helst i minnet
* At adressene til hver byte i minnet allokeres tilfeldig av operativsystemet 
* At det går like fort å skrive til minnet som å lese fra minnet
* At data som lagres kan bli lagt hvor som helst i minnet At alle enheter har tilgang til minnet

# Svar

### **At det tar like lang tid å hente en byte fra hvor som helst i minnet**

<br><br>

# 6(b) Internminne 
## Mange datamaskiner har et cache-minne mellom CPU og RAM. Vil det kunne føre til at det er forskjell i hvor lang tid det tar for CPU å hente inn to forskjellige bytes fra RAM til registerne i CPU’en? Forklar kort.


# Svar
### **Det burde ta like lang tid å hente de to forskjellige bytsene men hvis begge bytsene ligger ved siden av hverandre kan cache lagre andre byte når første byte hentes og dermed vil det gå fortere å hente andre byte hvis dette er tilfellet.**


<br><br>

## 6 (c)
## Internminne
## En matrise, også kalt et todimensjonalt array, er et sett av elementer ordnet i rader og kolonner. For eksempel kan en 2x2 matrise A[2][2] defineres i et C-program og den vil da ha 2x2 elementer: A[0][0], A[0][1], A[1][0] og A[1][1]. Når disse elementene lagres i RAM, lagres de etter hverandre som vist i eksempelet. I en 3x3 matrise lagres først A[0][0], A[0][1] og A[0][2] etter hverandre, så A[1][0], A[1][1] og så videre. Et C-program definerer en heltalls-matrise med int mat[5000][5000];. Hvis et heltall (integer, int) bruker 4 byte lagringsplass, hvor mange Megabyte består denne matrisen av? (La her Mega bety en million i SI-betydningen)

# Svar

### **5000 * 5000 * 4 / 1000000 = 100 megabytes**


---
<br><br>

## Internminne
## På en maskin med 2 GByte RAM har man følgende C-program:
```C
int mat[5000][5000];
    for(i = 0;i < 5000;i++){
        for(j = 0;j < 5000;j++){
    mat[i][j] = 5;
    }
}
```
## Programmet kompileres og kjøres:
    $ time a.out
    Real:0.113 User:0.020 System:0.092 99.39%
## Så endres kun en linje i programmet; linjen der matriseverdier legges inn endres til mat[j][i] = 5;. Når programmet så kompileres og kjøres, tar det nesten tre ganger så lang tid å kjøre det:
    $ time a.out
    Real:0.303 User:0.216 System:0.084 98.95%
## Hvordan kan dette forklares?

    Hele arrayet vil kunne være i minnet p ̊a en gang n ̊ar programmet kjøres, s ̊a paging er ikke en faktor her. Uten cache ville da programmet g ̊a like fort i begge tilfeller, siden det ville ta like lang tid  ̊a hente hvert matriseelement. Men i det første tilfellet ser man at arrayet skrives til i samme rekkefølge som det ligger
    4
    lagret i RAM. Dermed vil det skrives fortløpende til bytes etterhverandre i cache som s ̊a legges samlet ut i minnet. Dette g ̊ar mye raskeren enn i program to hvor det er 20000 byte mellom hvert matrise element som skrives til. Dermed vil det stort sett bare bli cache-miss og det g ̊ar totalt sett mye lengre tid  ̊a skrive til minnet.
