import { ComponentFixture, TestBed } from '@angular/core/testing';

import { DataCardsComponent } from './data-cards.component';

describe('DataCardsComponent', () => {
  let component: DataCardsComponent;
  let fixture: ComponentFixture<DataCardsComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ DataCardsComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(DataCardsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
