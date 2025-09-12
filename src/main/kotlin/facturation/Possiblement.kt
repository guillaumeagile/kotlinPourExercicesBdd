package org.example.facturation

import arrow.core.Either

/**
 * Façade française pour Either d'Arrow-kt
 * Améliore la lisibilité du code métier en français
 */
typealias Possiblement<Erreur, Valeur> = Either<Erreur, Valeur>

/**
 * Extensions françaises pour Either
 */
fun <E, A> Possiblement<E, A>.Echec(): Boolean = this.isLeft()
fun <E, A> Possiblement<E, A>.Succès(): Boolean = this.isRight()

/**
 * Fonctions de création avec vocabulaire français
 */
fun <E> E.echec(): Possiblement<E, Nothing> = Either.Left(this)
fun <A> A.succes(): Possiblement<Nothing, A> = Either.Right(this)

/**
 * Extensions pour pattern matching en français
 */
inline fun <E, A, B> Possiblement<E, A>.siEchec(action: (E) -> B): B? = 
    if (this.Echec()) action(this.leftOrNull()!!) else null

inline fun <E, A, B> Possiblement<E, A>.siSucces(action: (A) -> B): B? = 
    if (this.Succès()) action(this.getOrNull()!!) else null

/**
 * Fold avec vocabulaire français
 */
inline fun <E, A, B> Possiblement<E, A>.selon(
    siEchec: (E) -> B,
    siSucces: (A) -> B
): B = this.fold(siEchec, siSucces)
