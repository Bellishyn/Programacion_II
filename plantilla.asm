INICIALIZACION MACRO  CASO
        MOV     CX, 69H
        LEA     SI, INFOREN
        LEA     DI, INIREN
    @@CICLO:
        MOV     [SI], 00
        MOV     [DI], 0000
        INC     SI
        INC     DI
        INC     DI
        LOOP    @@CICLO
        MOV     DICAUX, 0000
ENDM

CURSOR  MACRO   REN, COL
        MOV     AH, 02
        MOV     BH, 00
        MOV     DH, REN
        MOV     DL, COL
        INT     10H
ENDM

LEER    MACRO
        MOV     AH, 10H
        INT     16H
ENDM

IMPRIME MACRO   MSJ
        MOV     DL, MSJ
        MOV     AH, 02
        INT     21H
ENDM

DESPLIEGUE MACRO CHAR, ATRIBUT, CANT
        MOV     AH, 09
        MOV     BH, 00
        MOV     AL, CHAR
        MOV     BL, ATRIBUT
        MOV     CX, CANT
        INT     10H
ENDM

IMPRIMECAD MACRO
        MOV     BX, DICAUX
        SUB     BX, 28H
        MOV     DX, [BX]
        MOV     AH, 09
        INT     21H
ENDM

SALTODELINEA MACRO
        MOV     BX, DICAUX
        MOV     [BX], SI
        ADD     DICAUX, 2
        MOV     BX, RENDIC
        MOV     AL, PUNTO2
        MOV     [BX], AL
        INC     RENDIC
        MOV     PUNTO2, 1
        CMP     PUNTO1, 15H
        JE      @@DESPLAZAMIENTO
        JMP     @@NORMAL
    @@DESPLAZAMIENTO:
        SLIDEUPCLEAN 01, 3FH, 0201H, 154DH
        JMP     @@FINAL
    @@NORMAL:
        INC     PUNTO1
    @@FINAL:
ENDM

REGRESARLINEA MACRO
        DEC     RENDIC
        MOV     BX, RENDIC
        MOV     AL, [BX]
        MOV     PUNTO2, AL
        CURSOR  PUNTO1, PUNTO2
        CMP     NUMREN, 14H
        JA     @@STATIC
        JMP     @@CHANGE
    @@STATIC:
        DEC     NUMREN
        SLIDEDOWNCLEAN 1
        CURSOR  02H, 01H
        IMPRIMECAD
        JMP     @@NOCHANGE
    @@CHANGE:
        DEC     NUMREN
        DEC     PUNTO1
    @@NOCHANGE:       
ENDM

BORRARTEXTO MACRO
        DEC     SI
        MOV     [SI], 00
        CMP     PUNTO2, 1
        JE      @@RL
        DEC     PUNTO2
        CURSOR  PUNTO1, PUNTO2
        IMPRIME 20H
        JMP     @@BREND
    @@RL:
        SUB     DICAUX, 02
        MOV     BX, DICAUX
        MOV     [BX], 0000H
        REGRESARLINEA
    @@BREND:
ENDM

SLIDEUPCLEAN MACRO CANT, ATRIBUT, LIM1, LIM2
        MOV     AH, 06
        MOV     AL, CANT
        MOV     BH, ATRIBUT
        MOV     CX, LIM1
        MOV     DX, LIM2
        INT     10H
ENDM

SLIDEDOWNCLEAN MACRO CANT, ATRIBUT, LIM1, LIM2
        MOV     AH, 07
        MOV     AL, CANT
        MOV     BH, 3FH
        MOV     CX, 0201H
        MOV     DX, 154DH
        INT     10H
ENDM

MARCO   MACRO
        CURSOR  01, 00
        IMPRIME 0DAH
        CURSOR  01, 4EH
        IMPRIME 0BFH
        CURSOR  16H, 00H
        IMPRIME 0C0H
        CURSOR  16H, 4EH
        IMPRIME 0D9H
        CURSOR  01, 01
        DESPLIEGUE 0C4H, 07H, 4DH
        CURSOR  16H, 01
        DESPLIEGUE 0C4H, 07H, 4DH
        MOV     CX, 14H
        MOV     PUNTO1, 02
        MOV     PUNTO2, 00H 
    @@BORDES:
        CURSOR  PUNTO1, PUNTO2
        IMPRIME 0B3H
        ADD     PUNTO2, 4EH
        CURSOR  PUNTO1, PUNTO2
        IMPRIME 0B3H
        SUB     PUNTO2, 4EH
        INC     PUNTO1
        LOOP    @@BORDES
ENDM

MENUUP  MACRO CAD
        CURSOR 00, 00
        LEA     DX, CAD
        MOV     AH, 09
        INT     21H
ENDM

MENULW  MACRO
        CURSOR 17H, 00
        LEA     DX, CAD3
        MOV     AH, 09
        INT     21H
        CURSOR 18H, 00
        DESPLIEGUE 30H, 37H, 01
ENDM

OPTION  MACRO 
        LEER
        MOV     OPC,AH
ENDM

CAPCAD  MACRO
        LEA     SI, CADU        
        XOR     CX, CX          ;CONTAR CARACTERES INGRESADOS
ENDM

CAPBUC  MACRO
  CAPBC:
        LEER
        CMP     AL, 0DH
        JE INPENDS
        CMP     CX, 80H
        JE LIMIT
        MOV     [SI], AL
        INC     SI
        INC     CX
        IMPRIME AL
        JMP CAPBC
  LIMIT:
        LEA DX, CAD2
        MOV AH,09
        INT 21H
        JMP INPENDS

INPENDS:
        MOV     [SI], '$'
ENDM
        

        
PILA    SEGMENT     PARA STACK 'STACK'
        DW 8192     DUP(?)
PILA    ENDS

DATOS   SEGMENT   PARA 'DATA'
TEXTO   DB 1740 DUP(?) ;TEXTO INICIA EN 0000H Y APUNTADORES EN 06CCH (SUJETO A CAMBIOS)
PUNTO1  DB      ?
PUNTO2  DB      ?
INFOREN DB 20   DUP(?)
INIREN  DW 20   DUP(?)
RENDIC  DW      ?
NUMREN  DB      1
DICAUX  DW      ?
OPC     DB      ?
CAD1    DB      'F2 EDIT  F3 SEARCH  F5 RECPLACE  F10 CLEAN SCREEN  ESC EXIT', '$'
CAD2    DB      'SE HA ALCANZADO EL LIMITE DE CARACTERES POSIBLES','$'
CAD3    DB      'PALABRA A BUSCAR: ','$'
CAD4    DB      'CANTIDAD: ','$'
CAD5    DB      'NUEVA PALABRA: ','$'
CADU    DB 128  DUP(?)
DATOS   ENDS

CODIGO  SEGMENT PARA 'CODE'
ASSUME  CS: CODIGO, DS: DATOS, SS: PILA

MAIN    PROC FAR
        PUSH    DS
        SUB     AX, AX
        PUSH    AX
        MOV     AX, DATOS
        MOV     DS, AX
        MOV     ES, AX
        SLIDEUPCLEAN 00, 37H, 0000H, 184FH
        SLIDEUPCLEAN 00, 7FH, 0000H, 174FH
        SLIDEUPCLEAN 00, 07H, 0100H, 164EH
        MARCO
        SLIDEUPCLEAN 00, 3FH, 0201H, 154DH
        
        MENUUP  CAD1
        
        CMP     OPC, 3CH
        JE EDIT
        
        CMP     OPC, 3DH
        JE SEARCH
        
        ;CMP     OPC, 3FH
        ;JE REPLACE
        
        ;CMP     OPC, 44H
        ;JE CLEAN
        
        ;CMP     OPC, 01H
        ;JE EXIT
        
        
EDIT:

MENUUP  CAD1       
REWRITE:    
        MOV     PUNTO1, 2
        MOV     PUNTO2, 1
        LEA     SI, TEXTO
        LEA     BX, INFOREN
        MOV     RENDIC, BX
        LEA     BX, INIREN
        MOV     [BX], SI
        MOV     DICAUX, BX
        ADD     DICAUX, 2
    ETIQ:
        CURSOR  PUNTO1, PUNTO2
        MOV     AH, 00
        INT     16H
        CMP     AH, 3DH         
        JE      SEARCH          
        CMP     AH, 1CH         
        JE      SL
        CMP     AH, 0EH         
        JE      BORRAR
        MOV     BH, NUMREN
        MOV     BL, PUNTO2
        XOR     BX, 144DH
        CMP     BX, 0000H
        JE      ALERTA
        IMPRIME AL
        INC     PUNTO2
        MOV     [SI], AL
        CMP     PUNTO2, 4DH
        JE      SL
        INC     SI
        JMP     ETIQ

        
    BORRAR:
        MOV     AH, PUNTO1
        MOV     AL, PUNTO2
        XOR     AX, 0201H
        CMP     AX, 0000H
        JE      INICIAR
        BORRARTEXTO
        JMP     ETIQ
    INICIAR:
        JMP     ETIQ    
    SL:
        CMP     NUMREN, 14H
        JE      RENSTATIC       
        MOV     [SI], 24H
        INC     SI
        INC     NUMREN    
        SALTODELINEA
    RENSTATIC:
        JMP ETIQ
        
    ALERTA:
        LEA     DI, CAD2
        MOV     PUNTO1, 17H
        MOV     PUNTO2, 0FH
    MSJALERT:
        CMP     [DI], 24H
        JE      RETURN
        CURSOR  PUNTO1, PUNTO2
        DESPLIEGUE [DI], 0E4H, 01
        INC     DI
        INC     PUNTO2
        JMP     MSJALERT
    RETURN:
        LEER
        CURSOR  17H, 0FH
        DESPLIEGUE 0DBH, 77H, 30H
        MOV     PUNTO1, 15H
        MOV     PUNTO2, 4DH
        JMP     ETIQ
        
SEARCH:
        MENULW
        CURSOR 23, 18
        CAPCAD
        CAPBUC
        ; COMPARAR CADENAS
        CURSOR 24, 10
        DESPLIEGUE 33H, 37H, 01
        ;SLIDEDOWNCLEAN
        JMP EDIT
        
        
        

        
        
        
    FINAL: 
        RET
MAIN    ENDP

CODIGO  ENDS
        END MAIN