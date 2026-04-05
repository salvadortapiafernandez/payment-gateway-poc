var builder = WebApplication.CreateBuilder(args);
builder.Services.AddEndpointsApiExplorer();
builder.Services.AddSwaggerGen();
var app = builder.Build();
app.UseSwagger();
app.UseSwaggerUI();

app.MapPost("/orders", (OrderRequest request) =>
{
    return Results.Ok(new { OrderId = Guid.NewGuid(), Status = "Created", Amount = request.Amount });
});

app.MapGet("/health", () => Results.Ok(new { status = "healthy" }));

app.Run();

record OrderRequest(decimal Amount, string Product);
