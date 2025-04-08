# Board Game API Parser

## Project Name
**Board Game API Parser**

## Description
A microservice that connects to the BGG API and then transforms the XML data into JSON.

## Building & Running

To build or run the project, use one of the following tasks:

| Task              | Description                                                          |
|-------------------|----------------------------------------------------------------------|
| `./gradlew test`  | Run the tests                                                        |
| `./gradlew build` | Build everything                                                     |
| `./gradlew run`   | Run the Aplication                                                   |

If the server starts successfully, you'll see the following output:

```
2024-12-04 14:32:45.584 [main] INFO  Application - Application started in 0.303 seconds.
2024-12-04 14:32:45.682 [main] INFO  Application - Responding at http://0.0.0.0:8081
```

## Endpoints

- `GET /search?parameters`: Retrieves list games information by parameters from the BGG API
    - **Parameters**:
        - **query=SEARCH_QUERY**: Returns all types of Items that match SEARCH_QUERY. Spaces in the SEARCH_QUERY are replaced by a +.
        - (Optional) **exact=1**: Limit results to items that match the SEARCH_QUERY exactly.
    - **Output**: JSON with all games list.
    - **Exceptions**:
        - Bad Request (Error 400): Query can not be empty.
        - Internal Server Error (Error 500): Internal error.

- `GET /details?parameters`: Retrieves game details information by parameters from the BGG API
    - **Parameters**:
        - **id=NNN**: Specifies the id of the thing(s) to retrieve. To request multiple things with a single query, NNN can specify a comma-delimited list of ids. Maximum 20.
    - **Output**: JSON with all games list.
    - **Exceptions**:
        - Bad Request (Error 400): ID can not be empty.
        - Illegal Number Exception (Error 400): ID need to be a number.
        - Internal Server Error (Error 500): Internal error.
