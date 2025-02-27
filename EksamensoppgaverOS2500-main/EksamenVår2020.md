# Eksamen 2020

# Datamaskinarkitektur

## 1
## Hvilken type logisk port er dette sannhetstabell for? A og B er input og UT er resultatet?

    A B  UT
    0 0  0
    0 1  1
    1 0  1
    1 1  1

## Velg ett alternativ

# Svar

    Or port


---
<br>
<br>

## 2
## Hva blir det logiske uttrykket F(A,B) for denne kretsen?

<img src="/Users/aziz/Documents/GitHub/EksamensoppgaverOS2500/Skjermbilde 2022-05-10 kl. 10.27.42.png">


# Svar
    F(A,) = A * B + B

---
<br>
<br>

## 3

## Uttrykket for den kretsen kan forenkles, utifra sannhetstabellen eller ved å bruke boolsk algebra. Hva kan uttrykket for F(A,B) forenkles til?

<img src="/Users/aziz/Documents/GitHub/EksamensoppgaverOS2500/Skjermbilde 2022-05-10 kl. 10.27.42.png">

# Svar

    F(A,B) = B 


--- 
<br><br>

# Threads

## 4
## Du lager en java-thread klasse hvor du deklarerer to variabler:
    int x; static int y;
## Deretter starter du opp mange slike threads. det vil da finnes:

## Velg ett alternativ

# Svar

    En felles variabel y og en variabel x i hver thread

---
<br>
<br>

# Prosesser

## 5
## I hvilken av følgende aktiviteter er OS-kjernen IKKE direkte involvert?

# Svar

    Hyperthreading

<br> <br>

## I denne og de følgende oppgavene skal vi studere kjøringen av et 100% CPU-avhengig C-program som kun består av en lang for-løkke som regner og regner med heltall. Dette programmet har blitt kompilert og kjørt på tre forskjellige Linux-servere, som i teksten kalles linux1, linux2 og linux3.

    Før kjøringen settes timeformat slik:
    TIMEFORMAT='Real:%R User:%U System:%S %P%%'
## for at output fra time-funksjonen skal bli mer kompakt. Følgende viser hvordan programmet kjøres på linux1:
    linux1$ gcc -O sum.c
    linux1$ time ./a.out
    Real:1.809 User:1.804 System:0.004 99.95%
## Forklar kort hva kommandoene (vist med uthevet skrift) gjør og hva de fire tallene i output viser.

## Svar

    TIMEFORMAT='Real:%R User:%U System:%S %P%%' formaterer output av tiden som viser hvor lang tid prosessen tok. Den viser hvor lang tid usermode tok og hvor lang tid systemet tok og totalt tid. I tilleg vises total CPU forbruk i prosent.

    gcc -O sum.c kommandoen kompilerer c programmet til de mest optimale maskininstruksjonene

    time ./a.out kommandoen kjører det kompilerte c 
    programmet og tar tiden på den. 

---

<br><br>

## 7
## Følgende viser på linux1-serveren to forskjellige måter å kjøre programmet på:
    linux1$ for i in {1..4} > do
    > time ./a.out
    > done
    Real:1.814 User:1.812 System:0.000 99.90% Real:1.797 User:1.792 System:0.000 99.73% Real:1.826 User:1.816 System:0.012 100.09% Real:1.836 User:1.832 System:0.000 99.77% linux1$
    linux1$ for i in {1..4} > do
    > time ./a.out&
    > done
    [1] 1329
    [2] 1330
    [3] 1332
    [4] 1334
    linux1$
    Real:1.803 User:1.796 System:0.000 99.63% Real:1.816 User:1.812 System:0.000 99.75% Real:1.854 User:1.828 System:0.020 99.69% Real:1.866 User:1.848 System:0.012 99.67%
## Forklar kort hva som skjer i de to kjøringene og forklar spesielt hva som er forskjellen på de to måtene å kjøre programmet på. Vil det være noen forskjell på hvor fort de to kjøringene fullføres? Forklar kort.

# Svar

    Den første for-løkken kjører og tar tiden p ̊a a.out fire ganger, men hver av kjøringene fullføres før den neste starter. Den andre for-løkken gjør det samme, men i dette tilfellet startes a.out som en bakgrunnsprosess slik at fire instanser av programmet kjøres i parallell p ̊a systemet(f ̊ar hver sin CPU, som kan sees av 100% CPU-bruk) . Dermed vil for den siste kjøringen alle de fire prosessene være ferdige etter ca 1.8 sekunder mens totaltiden for den første for-løkken er fire ganger s ̊a lang, ca 7.2 sekunder. 

---
<br><br>

## 8
## Linux 1
## Det følgende viser først kompilering og kjøring av det samme 100% CPU-avhengige programmet og så tre forskjellige kjøringer av programmet på den første av serverene, linux1. Forklar med utgangspunkt i tiden fra den første kjøringen de tidene som er resultatet av de tre kjøringene. Vis ved utregning hvordan størrelsen på Real- tiden omtrentlig kan beregnes utifra resultatet 1.8 sekunder i den første kjøringen. Forklar også prosent-tallene for hver kjøring. Prøv utifra resultatene av kjøringen å finne ut hvor mange cores (med en egen ALU) denne serveren har og om hver core er hyperthreading eller ikke. Forklar kort hvordan du kommer frem til din konklusjon.
    linux1$ gcc -O sum.c
    linux1$ time ./a.out
    Real:1.809 User:1.804 System:0.004 99.95%
    linux1$ for i in {1..4} > do
    > time ./a.out &
    > done
    Real:1.819 User:1.812 System:0.000 99.59% Real:1.833 User:1.812 System:0.004 99.08% Real:1.833 User:1.812 System:0.000 98.85% Real:1.855 User:1.836 System:0.004 99.21%


    linux1$ for i in {1..6}; do time ./a.out & done Real:2.510 User:1.800 System:0.000 71.70%
    Real:2.617 User:1.800 System:0.000 68.77% Real:2.661 User:1.804 System:0.008 68.09% Real:2.686 User:1.828 System:0.004 68.21% Real:2.806 User:1.800 System:0.008 64.42% Real:2.832 User:1.840 System:0.000 64.98%


    linux1$ for i in {1..8}; do time ./a.out & done Real:3.553 User:1.816 System:0.000 51.10%
    Real:3.594 User:1.844 System:0.000 51.30% Real:3.625 User:1.828 System:0.004 50.53% Real:3.623 User:1.812 System:0.016 50.45% Real:3.642 User:1.820 System:0.008 50.19% Real:3.650 User:1.812 System:0.004 49.75% Real:3.671 User:1.820 System:0.008 49.80% Real:3.746 User:1.836 System:0.004 49.11%


# Svar

    Utregning 1,8 * 4 / 4 = 1,8 - første kjøring viser at en 100% cpu avhengig prosess bruker 1,8 sekunder. 

    Andre kjøring 1,8 * 6 / 4 = 2,7 sekunder ca pr prosess. Her ser man at en prosess bruker ca 70% av cpu og os fordeler vcpu tid likt på alle prosessene

    Tredje kjøring 1,8 * 8 / 4 = 3,6 sekunder pr prosess. Og her ser man at alle prosessene får ca 50% cpu tid hver.

    Ut i fra disse utregningene kan man se at dette er en cpu med 4 ALU´er(regneenheter) fordi hvis man kjører flere prosesser så ser man at de får mindre og mindre cpu tid. Så dette er ikke en hyperthreading cpu ettersom OS hadde oppfattet de 4 CPU-ene som 8 og derfor vist 100% CPU tid på alle prosessene.

---

<br><br>


## linux2
## Det følgende viser først kompilering og kjøring av det samme 100% CPU-avhengige programmet og så tre forskjellige kjøringer av programmet på den andre av serverene, linux2. Forklar med utgangspunkt i tiden fra den første kjøringen de tidene som er resultatet av de tre kjøringene. Vis ved utregning hvordan størrelsen på Real- tiden omtrentlig kan beregnes utifra resultatet 0.6 sekunder i den første kjøringen. Prøv i dette tilfellet spesielt å forklare forskjellene i Real-tid mellom prosessene i den andre av de tre kjøringene (for i in {1..6}-kjøringen). Forklar også prosent-tallene for hver kjøring. Prøv utifra resultatene av kjøringen å finne ut hvor mange cores (med en egen ALU) denne serveren har og om hver core er hyperthreading eller ikke. Forklar kort hvordan du kommer frem til din konklusjon.

    linux2$ gcc -O sum.c 
    linux2$ time ./a.out
    Real:0.614 User:0.612 System:0.000 99.63%
    
    linux2$ for i in {1..4}; do time ./a.out& done 
    Real:0.634 User:0.628 System:0.000 99.06% 
    Real:0.633 User:0.628 System:0.000 99.15% 
    Real:0.634 User:0.628 System:0.000 98.97% 
    Real:0.637 User:0.624 System:0.000 97.98%

    linux2$ for i in {1..6}; do time ./a.out& done 
    Real:0.624 User:0.620 System:0.000 99.41% 
    Real:0.623 User:0.620 System:0.000 99.48% 
    Real:0.908 User:0.904 System:0.000 99.58% 
    Real:0.911 User:0.900 System:0.000 98.81% 
    Real:0.914 User:0.912 System:0.000 99.83% 
    Real:0.914 User:0.908 System:0.000 99.33%

    linux2$ for i in {1..8}; do time ./a.out& done 
    Real:1.182 User:1.180 System:0.000 99.82% 
    Real:1.186 User:1.180 System:0.000 99.48% 
    Real:1.188 User:1.184 System:0.000 99.70% 
    Real:1.186 User:1.184 System:0.000 99.80% 
    Real:1.187 User:1.184 System:0.000 99.73% 
    Real:1.187 User:1.184 System:0.000 99.75% 
    Real:1.188 User:1.184 System:0.000 99.69% 
    Real:1.192 User:1.176 System:0.000 98.69%


# Svar

    Første kjøring av ./a.out viser at en cpu avhengig prosess bruker ca 0,6 sekunder. 

    På neste kjøring kan man se at det blir kjørt 4 sånne prosesser som ca bruker like lang tid, 0,6 sekunder.

    Kjøring som starter 6 prosesser ser vi at den omtrentlig bruker 0.9 sekunder på 4 av de siste prosessene og 100% cpu bruk. Her kan man se at noen av prossene bruker gjennomsnittelig 0,3 sekunder mer selv om det ser ut som at de får 100% cpu så her kan man nesten være sikker på at dette er en hyperthreading cpu.

    Siste kjøring starter 8 prosesser og her kan man se at hver prosess bruker nesten dobbelt så lang tid selvom det er 100% cpu på hver prosess. Så her kan man med sikkerhet si at dette er en hyperthreading cpu med 4 cores men ser ved hjelp av hyperthreading så ser det ut som at denne skal ha 8 cores. 


---

<br>
<br>

## 3
## linux3
## Det følgende viser først kompilering og kjøring av det samme 100% CPU-avhengige programmet og så tre forskjellige kjøringer av programmet på den tredje av serverene, linux3. Forklar med utgangspunkt i tiden fra den første kjøringen de tidene som er resultatet av de tre kjøringene. Forklar også prosent-tallene for hver kjøring. Prøv utifra resultatene av kjøringen å finne ut hvor mange cores (med en egen ALU) denne serveren har og om hver core er hyperthreading eller ikke. Forklar kort hvordan du kommer frem til din konklusjon.
    linux3$ gcc -O sum.c 
    linux3$ time ./a.out
    Real:2.282 User:2.280 System:0.000 99.90%

    linux3$ for i in {1..4}; do time ./a.out& done 
    Real:2.283 User:2.280 System:0.000 99.85% 
    Real:2.291 User:2.280 System:0.000 99.53% 
    Real:2.293 User:2.280 System:0.000 99.41% 
    Real:2.294 User:2.280 System:0.000 99.41%

    linux3$ for i in {1..6}; do time ./a.out& done 
    Real:2.283 User:2.280 System:0.000 99.85% 
    Real:2.283 User:2.280 System:0.000 99.85% 
    Real:2.284 User:2.280 System:0.000 99.82% 
    Real:2.295 User:2.280 System:0.000 99.36% 
    Real:2.294 User:2.280 System:0.000 99.39% 
    Real:2.294 User:2.280 System:0.000 99.38%

    linux3$ for i in {1..8}; do time ./a.out& done 
    Real:2.284 User:2.280 System:0.000 99.84% 
    Real:2.284 User:2.280 System:0.000 99.81% 
    Real:2.284 User:2.280 System:0.000 99.82% 
    Real:2.283 User:2.280 System:0.000 99.85% 
    Real:2.286 User:2.280 System:0.000 99.72% 
    Real:2.289 User:2.280 System:0.000 99.59% 
    Real:2.287 User:2.280 System:0.000 99.68% 
    Real:2.294 User:2.280 System:0.000 99.37%

# Svar

    Første kjøring viser at en prosess tar 2.2 sekunder.

    Neste kjøring viser at det fremdeles tar ca 2.2 sekund på hver prosess når 4 prosesser kjøres samtidig. samme gjelder det når det kjøres 6 og 8 prosesser samtidig. Så her ser man at det ikke tar lenger tid jo flere prosesser som kjøres og dermed kan man med sikkerhet si at denne serveren har tilgang til 8 uavhengige cores(regneenheter). I tilleg kan vi ikke se om det er hyperthreading eller ikke ettersom tiden brukt på hver prosess holder seg lik. For å finne ut av dette må vi kjøre flere instanser av prosessen. 


---
<br><br>

# Docker
## 11
## Skriv en dockerfile som lager en container med default versjon av ubuntu og med apache2 installert. Og som gjør slik at filen index.html legges i /var/www/html på containeren. Sørg også for at apache startes når containeren startes.

    FROM ubuntu
    RUN apt-get -y update
    RUN apt-get -y install apache2
    COPY index.html /var/www/html
    CMD ["/usr/sbin/apachectl","-D","FOREGROUND"]
    

---

<br><br>

## 12
## Skriv ned en docker-kommando som med utgangspunkt i dockerfilen i forrige oppgave bygger et docker-image med navn ubuntuA. Forklar om det spiller noen rolle fra hvilken mappe kommandoen kjøres.

# Svar
    docker build -t ubuntuA .


---

<br><br>

## 13 
## Skriv ned en docker-kommando som bruker ubuntuA-imaget du bygde i forrige oppgave til å starte i bakgrunnen en container som svarer på web-tilkoblinger på port 5555 og viser siden index.html som ble inkludert i dockerfilen i den første docker-oppgaven. Blir index.html inkludert når image't ubuntuA bygges eller når containeren startes opp? Forklar kort.

# Svar

    docker container run -p 5555:80 -d ubuntuA 


--- 
<br><br>

# Internminne

## 14
## En byte skal kopieres til et register i CPU. Hvilken av følgende enheter går det raskest å kopiere fra?

# Svar
    L1 cache


---
<br><br>

# MMI
## 15
## Anta at en innkommende virtuell adresse til MMU er 8. Hva blir da den utgående fysiske adressen?

# Svar
    8200

---
<br><br>

# Linux kommandolinje

## 16
## Hvilken mappe referer . (ett punktum) til i et bash-shell?

# Svar
    Mappen under den du står i


---
<br><br>

## 17
## HHvilken Linux-kommando lager en tom fil med navn fil.txt??

# Svar
    touch fil.txt

---
<br><br>

## 18
## Hva slags Linux-filer pleier å ha filendelse .lin ?


# Svar

    Dette er ikke en vanlig filendelse i Linux


---

<br><br>

# Bash-scripting
## 19

## I et Linux bash-shell gir følgende kommando (vist i boldface)
    linux$ date -d 01:16:40
    ma. 04. mai 01:16:40 +0200 2020

## tidspunktet 16 minutter og 40 sekunder over kl 01 på dagens dato. Videre gir

    linux$ date -d 01:16:40 +%s 1588547800

## antall sekunder som har passert siden midnatt 1. januar 1970. Tilsvarende gir for et tidspunkt som er ett minutt og 10 sekunder senere:
    linux$ date -d 01:17:50 +%s 1588547870
## som dermed er et tall som er 70 sekunder større enn det forrige.

## Skriv et bash-script med navn time1.sh som tar et starttidspunkt og et slutttidspunkt på formen TT:MM:SS som argumenter og skriver ut forskjellen i antall sekunder mellom tidspunktene. Du kan anta at slutt er større enn start og trenger ikke å sjekke antall argumenter og om argumentene virkelig er på formen TT:MM:SS. Når scriptet kjører skal det gi resultater som vist nedenfor:
    linux$ ./time1.sh 01:16:40 01:16:50 10
    linux$ ./time1.sh 01:16:40 01:18:30 110
    linux$ ./time1.sh 01:18:50 02:18:50 3600
    linux$ ./time1.sh 01:18:50 02:19:00 3610


# Svar

    #! /bin/bash

    tid1=$(date -d "$1" +%s)

    tid2=$(date -d "$2" +%s)

    diff=$(( "$tid2" - "$tid1" ))

    echo "$diff"

---

<br><br>

## Når du bruker kommandoen date på følgende måte blir dette resultatet:
    linux$ date -d@10 -u +%H:%M:%S 
    00:00:10
    linux$ date -d@110 -u +%H:%M:%S 
    00:01:50
    linux$ date -d@3610 -u +%H:%M:%S 
    01:00:10
## Bruk dette til å lage en versjon 2 av scriptet fra forrige oppgave som du kaller time2.sh og som gir følgende output når det kjøres:
    linux$ ./time2.sh 01:16:40 01:16:50 
    00:00:10
    linux$ ./time2.sh 01:16:40 01:18:30 
    00:01:50
    linux$ ./time2.sh 01:18:50 02:18:50 
    01:00:00
    linux$ ./time2.sh 01:18:50 02:19:00 
    01:00:10
## Det skal altså gi forskjellen i tid mellom de to tidspunktene på formen TT:MM:SS
## Du kan anta at det andre tidspunktet er etter det første og du trenger ikke å sjekke antall argumenter og om argumentene virkelig er på formen TT:MM:SS

# Svar

    #! /bin/bash

    tid1=$(date -d "$1" +%s)

    tid2=$(date -d "$2" +%s)

    diff=$(( "$tid2" - "$tid1" ))

    dato=$(date -d@$diff -u +%H:%M:%S)

    echo "$dato"

---
<br>
<br>

# Powershell

## 22
## Vi har i bash-script oppgaven sett at i et Linux bash-shell gir følgende kommando (vist i boldface)
    linux$ date -d 01:16:40
    ma. 04. mai 01:16:40 +0200 2020
## En tilsvarende PowerShell-kommando gir:
    PS C:\Users\os> Get-Date 01:16:40 mandag 4. mai 2020 01.16.40
## Det er noen forskjeller i hvordan informasjonen skrives ut, men forklar hvilken fundamental forskjell det er på resultatet man får fra en PowerShell-kommando sammenlignet med det man får fra en Linux-kommando. (En forskjell som også finnes for andre kommandoer enn Get-Date. )