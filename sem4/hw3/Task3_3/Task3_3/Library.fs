module Task3_3

/// Description of the expression tree
type ExpressionOfLambdaTerm = 
    | Element of char
    | Expression of ExpressionOfLambdaTerm * ExpressionOfLambdaTerm
    | Function of char * ExpressionOfLambdaTerm

/// Function performing beta reduction according to normal strategy
let makeBetaReduction (expression : ExpressionOfLambdaTerm) = 

    /// Returns whether the given variable is free in this expression
    let rec isFree term var =
        match term with
        | Element x -> x = var
        | Function (x, expression) -> x <> var && (isFree expression x)
        | Expression (left, right) -> (isFree left var) || (isFree right var)

    /// Function that replaces the terminals in a given expression
    let rec substituteTerm name term expression =
         match expression with
         | Function (var, _) when var = name -> expression
         | Function (var, expr) when not (isFree term var) -> Function (var, substituteTerm name term expr)
         | Element x when  x = name -> term
         | Element _ -> expression
         | Expression (left, right) -> Expression (substituteTerm name term left, substituteTerm name term right)
         | Function (var, expr) ->
             let varibleNames = ['a'..'z'] |> List.filter (not << isFree term) |> List.head
             Function (varibleNames, substituteTerm name term (substituteTerm var (Element varibleNames) expr))

    /// Function that expands the expression tree
    let rec bypassExpressions phrase =
        match phrase with
        | Element _ -> phrase
        | Function (x, expression) -> Function (x, (bypassExpressions expression))
        | Expression (Function (x, expressionLeft), expressionRight) ->
            expressionLeft |> substituteTerm x expressionRight |> bypassExpressions
        | Expression (expressionLeft, expressionRight) ->
            let leftReduce = bypassExpressions expressionLeft

            match leftReduce with 
            | Function _ -> Expression (leftReduce, expressionRight) |> bypassExpressions
            | _ -> Expression (leftReduce, (bypassExpressions expressionLeft))

    bypassExpressions expression