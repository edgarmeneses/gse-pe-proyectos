import PyPDF2

pdf_path = 'Microservicio MsDatosGrafos V1.0.pdf'
output_path = 'MsDatosGrafos_extracted.txt'

pdf_reader = PyPDF2.PdfReader(pdf_path)
full_text = []

for i, page in enumerate(pdf_reader.pages, 1):
    full_text.append(f"\n{'='*80}\n")
    full_text.append(f"PÁGINA {i} de {len(pdf_reader.pages)}\n")
    full_text.append(f"{'='*80}\n\n")
    full_text.append(page.extract_text())

with open(output_path, 'w', encoding='utf-8') as f:
    f.write(''.join(full_text))

print(f'✅ Extraído: {output_path}')
