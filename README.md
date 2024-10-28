# Avaliação 1 - IMD0040 - Linguagem de Programação 2

## Instruções

- Esta prova será avaliada com base na implementação correta dos conceitos de Classes, Objetos, Pacotes, Enum, Static, Herança e Polimorfismo (estático e dinâmico).
- Os testes unitários já foram fornecidos. Execute-os para verificar se a sua implementação está correta.
- Leia atentamente os requisitos e implemente as classes necessárias seguindo as instruções.

## Problema: Sistema de Gerenciamento de Veículos

Implemente um sistema para gerenciar diferentes tipos de veículos. O sistema deve permitir o cadastro de veículos e o cálculo do imposto anual com base no tipo e nas características de cada veículo.

### Requisitos

1. **Pacotes e Classes**:
   - Crie o pacote `br.ufrn.imd` e, dentro dele, as seguintes classes:
     - `Vehicle` (classe base comum)
     - `Car`
     - `Motorcycle`
     - `VehicleFactory`

2. **Classe Vehicle**:
   - A classe `Vehicle` deve conter:
     - Um atributo `String licensePlate` (placa de identificação do veículo).
     - Um atributo `double value` (valor do veículo).
     - Um método `public double calculateTax()` que será sobreposto nas subclasses.
     - Um método estático `public static int getTotalVehicles()` que retorna o número total de veículos cadastrados.
   
3. **Classe Car**:
   - A classe `Car` deve herdar de `Vehicle` e conter:
     - Um atributo `int doors` (número de portas).
     - A sobreposição do método `calculateTax()`, que calcula o imposto anual como 3% do valor do veículo.

4. **Classe Motorcycle**:
   - A classe `Motorcycle` deve herdar de `Vehicle` e conter:
     - Um atributo `int engineCapacity` (capacidade do motor em cilindradas).
     - A sobreposição do método `calculateTax()`, que calcula o imposto anual como 1.5% do valor do veículo.

5. **Enum VehicleType**:
   - Crie um enum `VehicleType` com as opções `CAR` e `MOTORCYCLE`.

6. **Classe VehicleFactory**

- Crie a classe `VehicleFactory` com um método sobrecarregado `createVehicle`, que implementará **polimorfismo estático** (sobrecarga de métodos) para criar veículos de formas diferentes, dependendo dos parâmetros fornecidos:

   - `public static Vehicle createVehicle(VehicleType type, String licensePlate, double value, int spec)`  
     - Esse método cria e retorna um veículo com base no tipo (`CAR` ou `MOTORCYCLE`). O parâmetro `spec` é usado para definir o número de portas no caso de um `Car` ou a capacidade do motor no caso de uma `Motorcycle`.

   - `public static Vehicle createVehicle(VehicleType type, String licensePlate, double value)`  
     - Esse método cria um veículo com um valor padrão para o atributo específico (`spec`) do tipo de veículo. Por exemplo, para um `Car`, o número de portas pode ser definido como `4`, e para uma `Motorcycle`, a capacidade do motor pode ser definida como `150`.

> **Exemplo de uso da sobrecarga:**
> ```java
> // Criação de um Carro com número de portas especificado
> Vehicle carWithDoors = VehicleFactory.createVehicle(VehicleType.CAR, "ABC1234", 30000.0, 4);
>
> // Criação de uma Moto com capacidade do motor especificada
> Vehicle motorcycleWithEngine = VehicleFactory.createVehicle(VehicleType.MOTORCYCLE, "XYZ5678", 15000.0, 600);
>
> // Criação de um Carro com número de portas padrão (4)
> Vehicle defaultCar = VehicleFactory.createVehicle(VehicleType.CAR, "DEF5678", 25000.0);
>
> // Criação de uma Moto com capacidade de motor padrão (150)
> Vehicle defaultMotorcycle = VehicleFactory.createVehicle(VehicleType.MOTORCYCLE, "LMN1234", 10000.0);
> ```

7. **Polimorfismo Dinâmico**:
   - Utilize polimorfismo dinâmico para calcular o imposto de veículos.

### Exemplo de uso

```java
public class Main {
    public static void main(String[] args) {
        Vehicle car = VehicleFactory.createVehicle(VehicleType.CAR, "ABC1234", 30000.0, 4);
        Vehicle motorcycle = VehicleFactory.createVehicle(VehicleType.MOTORCYCLE, "XYZ5678", 15000.0, 600);

        System.out.println("Imposto do carro: " + car.calculateTax());
        System.out.println("Imposto da moto: " + motorcycle.calculateTax());

        System.out.println("Total de veículos cadastrados: " + Vehicle.getTotalVehicles());
    }
}
