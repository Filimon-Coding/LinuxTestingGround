# Eksamen vår 2021

## 1 Systemkall

### Et systemkall utføres når

## svar

    en prosess ber operativsystemkjernen om en tjeneste

---

<br> <br>

## 2 Modusbit

### Hva er en prosessors modusbit?

## svar
    Et bit som kan begrensse aksess til minne og instruksjoner

---

<br><br>

## 3 CPU-migration

## svar

    Det første scriptet starter to cpu avhengige prosesser som kjører på hver sin core. Det forekommer ingen cpu migrations ettersom det ikke er nødvendig siden det er to tilgjengelige cores. Når det er 3 prosesser som kjører på 2 cores vil os-scheduler gi like mye tid til hver prosess.



## 4 RUN og CMD
## Forklar forskjellen på RUN og CMD i Dockerfile

## Svar

    RUN er et bildebyggetrinn, statusen til beholderen etter en RUN-kommando vil bli forpliktet til beholderbildet. En Dockerfile kan ha mange RUN-trinn som legger seg oppå hverandre for å bygge bildet.

    CMD er kommandoen containeren kjører som standard når du starter det bygde bildet. En Dockerfil vil bare bruke den endelige CMD-en som er definert. CMD kan overstyres når du starter en container med docker-kjør $image $other_command.
    
## oppgave 24
--- 

    1 > Register 0 = 0
    2 > Register 1 = 1
    3 > Register 2 = 3
    4 > Register 3 = 1

    5 Add - Runde1 R3 = 1 + 1 = 2, runde2, 2 + 2 = 4 Runde3 4+4 = 8
    6 Add - Runde1 R0 + R1 = 1 - runde2, 1 + 1 = 2 = 2+1 = 3
    7 cmp R0, R2 = 1 er lik 3 =  er lkik
    8 JNE - sjekk om R0 er lik R2



## oppgave 25

    ADD 01000001
    CMP 11000010
    JNE 11110010


j = 3
 for(int i = 0; i < j; i++  ){
     i = i + i;
 }
 