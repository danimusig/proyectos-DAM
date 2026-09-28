#include <stdio.h>

int main() {
    FILE *fichero;
    fichero = fopen("salida.txt", "wt");
    if (fichero != NULL) {
        fputs("Este texto está generado por el proceso escrito en C", fichero);
        fclose(fichero);
    }
    return 0;
}
