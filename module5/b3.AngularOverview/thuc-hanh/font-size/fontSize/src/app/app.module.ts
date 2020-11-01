import {BrowserModule} from '@angular/platform-browser';
import {NgModule} from '@angular/core';

import {AppRoutingModule} from './app-routing.module';
import {AppComponent} from './app.component';
import {FonSizeComponent} from './fon-size/fon-size.component';
import {PetComponent} from './pet/pet.component';
import {FormsModule} from "@angular/forms";
import {CalculatorComponent} from './calculator/calculator.component';
import {ColorComponent} from './color/color.component';
import {HackernewsComponent} from './hackernews/hackernews.component';
import {RatingBarComponent} from './rating-bar/rating-bar.component';
import {CountdownTimerComponent} from './countdown-timer/countdown-timer.component';

@NgModule({
  declarations: [
    AppComponent,
    FonSizeComponent,
    PetComponent,
    CalculatorComponent,
    ColorComponent,
    HackernewsComponent,
    RatingBarComponent,
    CountdownTimerComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule {
}
