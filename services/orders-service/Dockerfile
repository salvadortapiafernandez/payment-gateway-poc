FROM mcr.microsoft.com/dotnet/sdk:8.0 AS build
WORKDIR /src
COPY . .
RUN dotnet new web -n OrdersService -f net8.0
WORKDIR /src/OrdersService
RUN dotnet add package Swashbuckle.AspNetCore   # <-- aquí, antes de copiar Program.cs (o después, pero siempre antes de publish)
COPY Program.cs /src/OrdersService/Program.cs
RUN dotnet publish -c Release -o /app/publish

FROM mcr.microsoft.com/dotnet/aspnet:8.0
WORKDIR /app
COPY --from=build /app/publish .
ENTRYPOINT ["dotnet", "OrdersService.dll"]