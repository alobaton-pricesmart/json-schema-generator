# json-schema-generator

Json Schema generator from a Java Pojo

## How to start?

Add your POJO to the following package `com.co.jsonschemagenerator.models` or to a package of your preference. 

Annotate your class with the following annotation `@GenerateJsonSchema`.

Run the command line runner application replacing your package in the following command.

```bash
mvn spring-boot:run -Dspring-boot.run.arguments="JsonSchemaGenerator com.co.jsonschemagenerator.models DRAFT_2020_12"
```

## Command line runner arguments

```bash
mvn spring-boot:run -Dspring-boot.run.arguments="<IMPLEMENTATION_NAME> <PACKAGE_TO_SCAN> <SCHEMA_VERSION>"
```

<style type="text/css">
.tg  {border-collapse:collapse;border-spacing:0;}
.tg td{border-color:black;border-style:solid;border-width:1px;font-family:Arial, sans-serif;font-size:14px;
  overflow:hidden;padding:10px 5px;word-break:normal;}
.tg th{border-color:black;border-style:solid;border-width:1px;font-family:Arial, sans-serif;font-size:14px;
  font-weight:normal;overflow:hidden;padding:10px 5px;word-break:normal;}
.tg .tg-0pky{border-color:inherit;text-align:left;vertical-align:top}
</style>
<table class="tg">
<thead>
  <tr>
    <th class="tg-0pky">argument</th>
    <th class="tg-0pky">default</th>
    <th class="tg-0pky">description</th>
  </tr>
</thead>
<tbody>
  <tr>
    <td class="tg-0pky">IMPLEMENTATION_NAME</td>
    <td class="tg-0pky"></td>
    <td class="tg-0pky">Required. This application relies on <a href="https://github.com/victools/jsonschema-generator">Victools Java JSON Schema Generator</a> and  <a href="https://github.com/confluentinc/schema-registry">Confluent Schema Registry</a> so you can scpecify which implementation do you want to use through the following argument  <span style="color:#905;background-color:#ddd">JsonSchemaGenerator</span> for Victools Java JSON Schema Generator and  <span style="color:#905;background-color:#ddd">KafkaJsonSchemaGenerator</span> for Confluent Schema Registry.</td>
  </tr>
  <tr>
    <td class="tg-0pky">PACKAGE_TO_SCAN</td>
    <td class="tg-0pky">com.co.jsonschemagenerator.models</td>
    <td class="tg-0pky">Optional. Package to scan.</td>
  </tr>
  <tr>
    <td class="tg-0pky">SCHEMA_VERSION</td>
    <td class="tg-0pky">DRAFT_7</td>
    <td class="tg-0pky">Optional. Required if using <span style="color:#905;background-color:#ddd">JsonSchemaGenerator</span></td>
  </tr>
</tbody>
</table>


